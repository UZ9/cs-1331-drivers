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

                        System.out.println("FAILED: " + tfe.getMessage());
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
