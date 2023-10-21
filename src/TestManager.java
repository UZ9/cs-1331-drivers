import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class TestManager {
    private static List<Class<?>> testClazzes = new ArrayList<>();
    public static void main(String[] args) {
        registerClass(StudentTests.class);
        registerClass(TrickOrTreaterTests.class);
        registerClass(GhostTests.class);
        
        executeTests();
    }

    public static void registerClass(Class<?> clazz) {
        testClazzes.add(clazz);
    }

    public static void executeTests() {
        int totalTests = 0;
        int totalTestsFailed = 0;

        for (Class<?> testClass : testClazzes) {
            try {
                StringUtils.printHorizontalLine();
                StringUtils.printTextCentered(testClass.getName());
                System.out.println();

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
                                    System.out.printf("\tHINT: %s\n", tip.tip());
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

}
