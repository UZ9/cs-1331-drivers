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
