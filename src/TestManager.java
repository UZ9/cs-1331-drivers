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


