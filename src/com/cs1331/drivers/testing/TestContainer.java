package com.cs1331.drivers.testing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import com.cs1331.drivers.annotations.AfterTest;
import com.cs1331.drivers.annotations.BeforeTest;
import com.cs1331.drivers.annotations.TestCase;
import com.cs1331.drivers.annotations.Tip;
import com.cs1331.drivers.exception.TestFailedException;
import com.cs1331.drivers.utils.AsciiColorCode;
import com.cs1331.drivers.utils.ColorUtils;
import com.cs1331.drivers.utils.StringUtils;
import com.cs1331.drivers.utils.Tuple;

import java.util.ArrayList;

/**
 * Represents a Runnable that can be thrown into a ThreadPoolExecutor. The
 * TestContainer will latch onto a Class<?> and attempt to run any methods
 * labeled as test functions, e.g. @TestCase or @BeforeTest
 */
public class TestContainer implements Runnable {
    /**
     * The class belonging to the TestContainer
     */
    private Class<?> clazz;

    /**
     * As the methods are non-static, there must be an instance all share when
     * executing the methods. At the start of the test a single instance is
     * initialized for all tests to use.
     */
    private Object instance = null;

    /**
     * Initializes a new TestContainer. A TestContainer is used to prevent certain
     * edge cases such as infinite loops.
     * 
     * If an infinite loop occurs, the test will timeout and notify the user
     * accordingly.
     * 
     * @param clazz The class containing the tests
     */
    public TestContainer(Class<?> clazz) {
        this.clazz = clazz;
    }

    /**
     * Executes a method belonging to this instance.
     * This is used when cycling over the methods marked with @BeforeTest
     * and @AfterTest, as both require the same invocation logic.
     * 
     * @param method The method to execute
     */
    private void executeFunction(Method method) {
        try {
            method.invoke(instance);
        } catch (Exception e) {
            System.out.println(ColorUtils.formatColorString(AsciiColorCode.WHITE_BACKGROUND,
                    AsciiColorCode.RED_FOREGROUND,
                    "\tThe executed code caused the following exception."));

            e.getCause().printStackTrace();
        }
    }

    /**
     * Attempts to execute a TestCase found within the TestContainer.
     * 
     * @param tuple A Tuple<Method, TestCase> containing the method to run, and the
     *              TestCase associated with it. These are wrapped into a Tuple to
     *              avoid having to call getAnnotation twice.
     * @return true if the test case was successful
     */
    private boolean executeTestCase(Tuple<Method, TestCase> tuple) {
        Method m = tuple.first;
        TestCase testCase = tuple.second;
        Tip tip = m.getAnnotation(Tip.class);

        try {

            m.invoke(instance);

            System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_GREEN_BACKGROUND,
                    AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " PASSED \u00BB ") + " "
                    + testCase.name());
        } catch (InvocationTargetException e) {
            System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_RED_BACKGROUND,
                    AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " FAILED \u00BB ") + " "
                    + testCase.name());

            if (e.getCause() instanceof TestFailedException) {
                TestFailedException tfe = (TestFailedException) e.getCause();

                System.out.println(StringUtils.formatIndented(tfe.getMessage()));

                } else if (e.getCause() instanceof StackOverflowError) {
                e.printStackTrace();
                
                System.out.println(ColorUtils.formatColorString(AsciiColorCode.WHITE_BACKGROUND,
                        AsciiColorCode.RED_FOREGROUND,
                        "\tYour code resulted in a StackOverflowError. This is almost certainly because of a recursive method stuck in an infinite loop."));

            } else {
                System.out.println(ColorUtils.formatColorString(AsciiColorCode.WHITE_BACKGROUND,
                        AsciiColorCode.RED_FOREGROUND,
                        "\tThe executed code caused the following exception. This is NOT the fault of the driver."));

                e.getCause().printStackTrace();
            }

            if (tip != null)
                    System.out.print(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_WHITE_BACKGROUND,
                            AsciiColorCode.BLACK_FOREGROUND, StringUtils.formatIndented(String.format("%s\n", "HINT: " + tip.description()))));
            

            return false;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public void run() {
        try {
            TestManager.printTestCategory(clazz.getName());

            instance = clazz.getDeclaredConstructor().newInstance();

            int classTests = 0;
            int classTestsFailed = 0;

            // TODO: Likely move this to a more abstract system
            List<Tuple<Method, BeforeTest>> beforeTest = new ArrayList<>();
            List<Tuple<Method, AfterTest>> afterTest = new ArrayList<>();
            List<Tuple<Method, TestCase>> testMethods = new ArrayList<>();

            for (Method m : clazz.getMethods()) {
                TestCase testAnnotation = m.getAnnotation(TestCase.class);
                BeforeTest beforeTestAnnotation = m.getAnnotation(BeforeTest.class);
                AfterTest afterTestAnnotation = m.getAnnotation(AfterTest.class);

                if (testAnnotation != null) {
                    testMethods.add(new Tuple<Method, TestCase>(m, testAnnotation));
                } else if (beforeTestAnnotation != null) {
                    beforeTest.add(new Tuple<Method, BeforeTest>(m, beforeTestAnnotation));
                } else if (afterTestAnnotation != null) {
                    afterTest.add(new Tuple<Method, AfterTest>(m, afterTestAnnotation));
                }
            }

            for (Tuple<Method, TestCase> tuple : testMethods) {

                for (Tuple<Method, BeforeTest> beforeTuple : beforeTest) {
                    executeFunction(beforeTuple.first);
                }

                boolean result = executeTestCase(tuple);

                classTests++;

                if (!result)
                    classTestsFailed++;
            }

            for (Tuple<Method, AfterTest> tuple : afterTest) {
                executeFunction(tuple.first);
            }

            TestManager.classTests.set(TestManager.classTests.get() + classTests);
            TestManager.classTestsFailed.set(TestManager.classTestsFailed.get() + classTestsFailed);

            System.out.println();
            StringUtils.printTextCentered(
                    String.format("TESTS PASSED: %d/%d", classTests - classTestsFailed, classTests));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}