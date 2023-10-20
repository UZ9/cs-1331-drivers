public class TestFunction {
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
}
