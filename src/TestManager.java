import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
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

    /**
     * A list of the currently registered classes to test
     */
    private static final List<Class<?>> testClazzes = new ArrayList<>();

    /**
     * When this method is called, the TestManager will run all tests in the given classes.
     * @param classes The classes to test.
     */
    public static void runTestsOn(Class<?> ... classes) {

        for (Class<?> currentClass : classes) {
            registerClass(currentClass);
        }
        
        executeTests();
    }

    /**
     * Registers and marks test class to be scanned during test execution.
     * 
     * @param clazz The input class
     */
    public static void registerClass(Class<?> clazz) {
        testClazzes.add(clazz);
    }

    /**
     * Executes all registered tests.
     */
    public static void executeTests() {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        List<Runnable> runnables = new ArrayList<>();

        for (Class<?> testClass: testClazzes) {
            runnables.add(new TestContainer(testClass));
        }

        
        for (Runnable r : runnables) {
            Future<?> future = executor.submit(r);

            try {
                future.get(4, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                
            } catch (ExecutionException e) {                
                e.getCause().printStackTrace();
            } catch (TimeoutException e) {
                future.cancel(true);

                System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_RED_BACKGROUND,
                AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " FAILED: \u00BB ") + " A test failed by exceeding the time limit. You likely have an infinite loop somewhere.");

                System.exit(-1);
            }

        }

        executor.shutdown();

        StringUtils.printHorizontalLine();

        StringUtils.printTextCentered("Test Results");
        System.out.println();
        StringUtils.printTextCentered(
                String.format("TOTAL TESTS PASSED: %d/%d", classTests.get() - classTestsFailed.get(), classTests.get()));
        StringUtils.printHorizontalLine();

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
}
