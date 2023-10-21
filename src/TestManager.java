import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class TestManager {
    /**
     * A list of the currently registered classes to test
     */
    private static List<Class<?>> testClazzes = new ArrayList<>();

    public static void main(String[] args) {

        // REGISTER CLASSES HERE
        registerClass(TrickOrTreaterTests.class);

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
        int totalTests = 0;
        int totalTestsFailed = 0;

        for (Class<?> testClass : testClazzes) {
            try {
                printTestCategory(testClass.getName());

                Object instance = testClass.getDeclaredConstructor().newInstance();

                int classTests = 0;
                int classTestsFailed = 0;

                for (Method m : testClass.getMethods()) {
                    TestCase testCase = (TestCase) m.getAnnotation(TestCase.class);
                    Tip tip = (Tip) m.getAnnotation(Tip.class);

                    if (testCase != null) {
                        try {

                            m.invoke(instance);

                            System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_GREEN_BACKGROUND,
                                    AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " PASSED: \u00BB ") + " "
                                    + testCase.name());
                        } catch (InvocationTargetException e) {
                            if (e.getCause() instanceof TestFailedException) {
                                TestFailedException tfe = (TestFailedException) e.getCause();

                                System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_RED_BACKGROUND,
                                        AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " FAILED: \u00BB ") + " "
                                        + testCase.name());

                                System.out.println("\t" + tfe.getMessage());

                                classTestsFailed++;
                                if (tip != null)
                                    System.out.printf("\tHINT: %s\n", tip.description());
                            } else {
                                e.getCause().printStackTrace();
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        }

                        classTests++;
                    }
                }

                totalTests += classTests;
                totalTestsFailed += classTestsFailed;

                System.out.println();
                StringUtils.printTextCentered(
                        String.format("TESTS PASSED: %d/%d", classTests - classTestsFailed, classTests));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        StringUtils.printHorizontalLine();

        StringUtils.printTextCentered("Test Results");
        System.out.println();
        StringUtils.printTextCentered(
                String.format("TOTAL TESTS PASSED: %d/%d", totalTests - totalTestsFailed, totalTests));
        StringUtils.printHorizontalLine();

    }

    /**
     * Prints a formatted test category section
     * 
     * @param category The name of the section (most likely the class name)
     */
    private static void printTestCategory(String category) {
        StringUtils.printHorizontalLine();
        StringUtils.printTextCentered(category);
        System.out.println();
    }
}
