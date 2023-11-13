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

class TestManager {
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
    public static void runTestsOn(Class<?>... classes) {
        for (Class<?> currentClass : classes) {
            registerClass(currentClass);
        }

        executeTests();
    }

    public static void registerDataClasses(Class<?>... classes) {
        for (Class<?> clazz : classes) {
            registerDataClass(clazz);
        }
    }

    /**
     * Registers and marks test class to be scanned during test execution.
     * 
     * @param clazz The input class
     */
    public static void registerClass(Class<?> clazz) {
        if (filter.size() == 0 || filter.stream().anyMatch(s -> s.equals(clazz.getName()))) {
            testClazzes.add(clazz);
        }
    }

    public static void registerDataClass(Class<?> clazz) {
        dataClazzes.add(clazz);
    }

    /**
     * Executes all registered tests.
     */
    public static void executeTests() {
        injectData();

        ExecutorService executor = Executors.newFixedThreadPool(1);

        List<Runnable> runnables = new ArrayList<>();

        for (Class<?> testClass : testClazzes) {
            runnables.add(new TestContainer(testClass));
        }

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
                        AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " FAILED: \u00BB ")
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

    }

    private static void injectData() {

        for (Class<?> dataClass : dataClazzes) {
            for (Field f : dataClass.getFields()) {
                InjectData injectAnnotation = f.getAnnotation(InjectData.class);

                if (injectAnnotation != null) {
                    Scanner scanner = null;

                    StringBuilder output = new StringBuilder();

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
            // getClass().getDeclaredField()
            // setAccessible

            // Field modifiers = getDeclaredField("modifiers")

            // modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            // field.set(instance, newValue);
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

    protected static void submitTest(int result) {
        // classTests++;
        // classTestsFailed += result;
    }

    public static void setTestFilter(List<String> filter) {
        TestManager.filter = filter;
    }
}
