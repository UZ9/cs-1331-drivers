import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class TestManager {
    public static void main(String[] args) {

        List<Class<?>> testClasses = new ArrayList<>();

        // TODO: Move to annotation scanning
        testClasses.add(StudentTests.class);

        for (Class<?> testClass : testClasses) {
            try {

                Object instance = testClass.getDeclaredConstructor().newInstance();

                for (Method m : testClass.getMethods()) {
                    TestCase testCase = (TestCase) m.getAnnotation(TestCase.class);
                    Tip tip = (Tip) m.getAnnotation(Tip.class);

                    if (testCase != null) {
                        try {
                            StringUtils.printHorizontalLine();

                            System.out.println("Testing: " + testCase.name());

                            m.invoke(instance);

                            System.out.println("Success!");
                        } catch (InvocationTargetException e) {
                            if (e.getCause() instanceof TestFailedException) {
                                TestFailedException tfe = (TestFailedException) e.getCause();

                                System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_RED_BACKGROUND,
                                        AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " FAILED: \u00BB ") + " "
                                        + tfe.getMessage());
                                if (tip != null)
                                    System.out.println("HINT: " + tip.tip());
                            } else {
                                e.getCause().printStackTrace();
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
