import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;

class TestContainer implements Runnable {
    private Class<?> clazz;
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

    private boolean executeTestCase(Tuple<Method, TestCase> tuple) {
        Method m = tuple.first;
        TestCase testCase = tuple.second;
        Tip tip = m.getAnnotation(Tip.class);

        try {

            m.invoke(instance);

            System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_GREEN_BACKGROUND,
                    AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " PASSED: \u00BB ") + " "
                    + testCase.name());

            TestManager.submitTest(0);
        } catch (InvocationTargetException e) {
            System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_RED_BACKGROUND,
                    AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " FAILED: \u00BB ") + " "
                    + testCase.name());

            if (e.getCause() instanceof TestFailedException) {
                TestFailedException tfe = (TestFailedException) e.getCause();

                System.out.println("\t" + tfe.getMessage());

                if (tip != null)
                    System.out.printf("\tHINT: %s\n", tip.description());
            } else {
                System.out.println(ColorUtils.formatColorString(AsciiColorCode.WHITE_BACKGROUND,
                        AsciiColorCode.RED_FOREGROUND,
                        "\tThe executed code caused the following exception. This is NOT the fault of the driver."));

                e.getCause().printStackTrace();
            }

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

            for (Tuple<Method, BeforeTest> tuple : beforeTest) {
                executeFunction(tuple.first);
            }

            for (Tuple<Method, TestCase> tuple : testMethods) {
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