package com.cs1331.drivers.testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

import com.cs1331.drivers.annotations.InjectData;
import com.cs1331.drivers.utils.AsciiColorCode;
import com.cs1331.drivers.utils.ColorUtils;
import com.cs1331.drivers.utils.StringUtils;

import javafx.stage.Stage;

public class TestManager {
    protected volatile static AtomicInteger classTests = new AtomicInteger();
    protected volatile static AtomicInteger classTestsFailed = new AtomicInteger();

    private static List<String> filter;

    /**
     * A list of the currently registered classes to test
     */
    private static final List<Class<?>> testClazzes = new ArrayList<>();

    /**
     * A list of the currently registered data classes
     */
    private static final List<Class<?>> dataClazzes = new ArrayList<>();

    /**
     * When this method is called, the TestManager will run all tests in the given
     * classes.
     * 
     * @param classes The classes to test.
     */
    public static void runTestsOn(Stage stage, Class<?>... classes) {
        for (Class<?> currentClass : classes) {
            registerClass(currentClass);
        }

        executeNextTest(stage);
    }

    public static void registerDataClasses(Class<?>... classes) {
        for (Class<?> clazz : classes) {
            registerDataClass(clazz);
        }
    }

    private static int currentTestChain = 0;

    /**
     * Registers and marks test class to be scanned during test execution.
     * 
     * @param clazz The input class
     */
    public static void registerClass(Class<?> clazz) {
        if (filter == null || filter.isEmpty() || filter.stream().anyMatch(s -> s.equals(clazz.getName()))) {
            testClazzes.add(clazz);
        }
    }

    public static void registerDataClass(Class<?> clazz) {
        dataClazzes.add(clazz);
    }

    public static void startNextTestSuite() {

    }

    /**
     * Executes all registered tests.
     */
    public static void executeNextTest(Stage stage) {
        injectData(stage);

        ExecutorService executor = Executors.newFixedThreadPool(1);

        List<Runnable> runnables = new ArrayList<>();

        runnables.add(new TestContainer(testClazzes.get(currentTestChain)));

        // for (Class<?> testClass : testClazzes) {
        //     runnables.add(new TestContainer(testClass));
        // }

        for (Runnable r : runnables) {
            Future<?> future = executor.submit(r);

            try {
                future.get(10, TimeUnit.SECONDS);
            } catch (InterruptedException ignored) {

            } catch (ExecutionException e) {
                e.getCause().printStackTrace();
            } catch (TimeoutException e) {
                future.cancel(true);

                System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_RED_BACKGROUND,
                        AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " FAILED \u00BB ")
                        + " A test failed by exceeding the time limit. You likely have an infinite loop somewhere.");

                System.exit(-1);
            }

        }

        executor.shutdown();

        StringUtils.printHorizontalLine();

        StringUtils.printTextCentered("Test Results");
        System.out.println();
        StringUtils.printTextCentered(
                String.format("TOTAL TESTS PASSED: %d/%d", classTests.get() - classTestsFailed.get(),
                        classTests.get()));
        StringUtils.printHorizontalLine();

        currentTestChain++;

    }

    private static void injectData(Stage stage) {

        for (Class<?> dataClass : dataClazzes) {
            for (Field f : dataClass.getFields()) {
                InjectData injectAnnotation = f.getAnnotation(InjectData.class);

                if (injectAnnotation != null) {
                    Scanner scanner = null;

                    StringBuilder output = new StringBuilder();

                    if (injectAnnotation.name().equals("stage")) {
                        f.setAccessible(true);

                        try {
                            f.set(null, stage);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        
                        return;
                    } else {
                        try {
                            scanner = new Scanner(new File(injectAnnotation.name()));

                            while (scanner.hasNextLine()) {
                                output.append(scanner.nextLine()).append("\n");
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("COULDN'T FIND INJECT DATA FILE " + injectAnnotation.name());
                            System.exit(-1);
                        } finally {
                            if (scanner != null) {
                                scanner.close();
                            }
                        }
                    }

                    // Inject data into variable
                    f.setAccessible(true);

                    try {
                        // Set private static final
                        f.set(null, output.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }

                }
            }
        }
    }

    /**
     * Prints a formatted test category section
     * 
     * @param category The name of the section (most likely the class name)
     */
    protected static void printTestCategory(String category) {
        StringUtils.printHorizontalLine();
        StringUtils.printTextCentered(category);
        System.out.println();
    }

    /**
     * Sets a filter to determine what test class files can be run.
     * This is primarily used in the CLI options.
     * 
     * @param filter The filter of classes
     */
    public static void setTestFilter(List<String> filter) {
        TestManager.filter = filter;
    }
}
