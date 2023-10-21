public class ColorUtils {
    public static String formatBackgroundColorString(String background, String s) {
        return background + s + AsciiColorCode.RESET_COLOR;
    }

    public static String formatForegroundColorString(String foreground, String s) {
        return foreground + s + AsciiColorCode.RESET_COLOR;

    }

    public static String formatColorString(String background, String foreground, String s) {
        return foreground + background + s + AsciiColorCode.RESET_COLOR;
    }
}
class TestFunction {
    public static void shouldEqual(String a, String b) throws TestFailedException {
        boolean failed = false;
        
        if (a == null) {
            failed = a != b;
        } else {

            if (!a.equals(b)) {
                failed = true;
            }
        }
        
        
        if (failed) {
            throw new TestFailedException("Equals Difference: " + a + " != " + b);
        }
    }

    public static void shouldEqual(int a, int b) throws TestFailedException {
        boolean failed = (a != b);
        if (failed) {
            throw new TestFailedException("Integer value difference: " + a + " != " + b);
        }
    }

    public static void shouldEqual(double a, double b) throws TestFailedException {
        final double ALLOWABLE_ERROR = 0.000001;

        boolean failed = (Math.abs(a - b) > ALLOWABLE_ERROR);

        if (failed) {
            throw new TestFailedException("Double value difference: " + a + " != " + b);
        }
    }

    public static void shouldEqual(boolean a, boolean b) throws TestFailedException {
        boolean failed = (a != b);

        if (failed) {
            throw new TestFailedException("Boolean value difference: " + a + " != " + b);
        }
    }
}
class TestUtils {
    public static void printDebug(String s) {
        System.out.println("DEBUG: " + s);
    }
}
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TestManager {
    public static void main(String[] args) {

        StudentTests studentTests = new StudentTests();
        
        for (Method m : studentTests.getClass().getMethods()) {
            TestCase testCase = (TestCase) m.getAnnotation(TestCase.class);
            Tip tip = (Tip) m.getAnnotation(Tip.class);


            if (testCase != null) {
                try {
                    System.out.println("Testing: " + testCase.name());

                    m.invoke(studentTests);

                    System.out.println("Success!");
                } catch (InvocationTargetException e) {
                    if (e.getCause() instanceof TestFailedException) {
                        TestFailedException tfe = (TestFailedException) e.getCause();

                        System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_RED_BACKGROUND, AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " FAILED: \u00BB ") + " " + tfe.getMessage());
                        if (tip != null) System.out.println("HINT: " + tip.tip());
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
    }
    

}


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Tip {
    public String tip() default "";
}
public final class AsciiColorCode {

    public static final String RESET_COLOR = "\033[0m";

    public static final String BLACK_FOREGROUND = "\033[30m";
    public static final String BLACK_BACKGROUND = "\033[40m";

    public static final String RED_FOREGROUND = "\033[31m";
    public static final String RED_BACKGROUND = "\033[41m";

    public static final String GREEN_FOREGROUND = "\033[32m";
    public static final String GREEN_BACKGROUND = "\033[42m";

    public static final String YELLOW_FOREGROUND = "\033[33m";
    public static final String YELLOW_BACKGROUND = "\033[43m";

    public static final String BLUE_FOREGROUND = "\033[34m";
    public static final String BLUE_BACKGROUND = "\033[44m";

    public static final String MAGENTA_FOREGROUND = "\033[35m";
    public static final String MAGENTA_BACKGROUND = "\033[45m";

    public static final String CYAN_FOREGROUND = "\033[36m";
    public static final String CYAN_BACKGROUND = "\033[46m";

    public static final String WHITE_FOREGROUND = "\033[37m";
    public static final String WHITE_BACKGROUND = "\033[47m";

    public static final String BRIHGT_BLACK_FOREGROUND = "\033[90m";
    public static final String BRIGHT_BLACK_BACKGROUND = "\033[100m";

    public static final String BRIGHT_RED_FOREGROUND = "\033[91m";
    public static final String BRIGHT_RED_BACKGROUND = "\033[101m";

    public static final String BRIGHT_GREEN_FOREGROUND = "\033[92m";
    public static final String BRIGHT_GREEN_BACKGROUND = "\033[102m";

    public static final String BRIGHT_YELLOW_FOREGROUND = "\033[93m";
    public static final String BRIGHT_YELLOW_BACKGROUND = "\033[103m";

    public static final String BRIGHT_BLUE_FOREGROUND = "\033[94m";
    public static final String BRIGHT_BLUE_BACKGROUND = "\033[104m";

    public static final String BRIGHT_MAGENTA_FOREGROUND = "\033[95m";
    public static final String BRIGHT_MAGENTA_BACKGROUND = "\033[105m";

    public static final String BRIGHT_CYAN_FOREGROUND = "\033[96m";
    public static final String BRIGHT_CYAN_BACKGROUND = "\033[106m";

    public static final String BRIGHT_WHITE_FOREGROUND = "\033[97m";
    public static final String BRIGHT_WHITE_BACKGROUND = "\033[107m";
}
class TestFailedException extends Exception {
    public TestFailedException() {

    }

    public TestFailedException(String message) {
        super(message);
    }
}
class StudentTests {
    @Tip(tip = "Make sure you don't have any field shadowing in your constructor!")
    @TestCase(name = "Student Constructor should set name to input when initialized")
    public void studentConstructor_shouldSetNameToInput_whenInitialized() throws TestFailedException {
        Student student = new Student("Bob");

        TestFunction.shouldEqual(student.getName(), "Bob");
    }
}
public class Student {
    private String name;
    
    public Student(String name) {
        name = name;
    }

    public String getName() {
        return name;
    }
}
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@interface TestCase {
    public String name() default "UNNAMED_TEST";
}
