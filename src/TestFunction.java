class TestFunction {
    /**
     * Detects if the given Strings do not have the same content (case-sensitive)
     * @param received
     * @param expected
     * @throws TestFailedException
     */
    public static void assertEqual(String received, String expected) throws TestFailedException {
        boolean failed = false;

        if (received == null) {
            failed = received != expected;
        } else {

            if (!received.equals(expected)) {
                failed = true;
            }
        }

        if (failed) {
            throw new TestFailedException("Strings different! Received \"" + received + "\", expected \"" + expected + "\"");
        }
    }

    /**
     * Detects if the given integers are not equal.
     * @param received
     * @param expected
     * @throws TestFailedException
     */
    public static void assertEqual(int a, int b) throws TestFailedException {
        boolean failed = (a != b);
        if (failed) {
            throw new TestFailedException("Integer value difference: " + a + " != " + b);
        }
    }

    /**
     * Detects if the given doubles are not within 1.0e-6 of one another.
     * @param a
     * @param b
     * @throws TestFailedException
     */
    public static void assertEqual(double a, double b) throws TestFailedException {
        final double ALLOWABLE_ERROR = 0.000001;

        boolean failed = (Math.abs(a - b) > ALLOWABLE_ERROR);

        if (failed) {
            throw new TestFailedException("Double value difference: " + a + " != " + b);
        }
    }

    /**
     * Detects if the given booleans do not have equal values.
     * @param a
     * @param b
     * @throws TestFailedException
     */
    public static void assertEqual(boolean a, boolean b) throws TestFailedException {
        assertEqual(a, b, "");
    }

    /**
     * Detects if the given booleans do not have equal values.
     * @param a
     * @param b
     * @param label
     * @throws TestFailedException
     */
    public static void assertEqual(boolean a, boolean b, String label) throws TestFailedException {
        boolean failed = (a != b);

        if (failed) {
            if (label.isEmpty()) {
                throw new TestFailedException("Boolean value difference: " + a + " != " + b);
            } else {
                throw new TestFailedException(label + "\nBoolean value difference: " + a + " != " + b);
            }
        }
    }

    /**
     * Detects if the given Exceptions are the same TYPE, not if they are caused by the same thing. Any two
     * NullPointerExceptions will, when passed into this function, return true, even if they are cuased by
     * two unrelated issues.
     * @param a
     * @param b
     * @throws TestFailedException
     */
    public static void assertEqual(Exception a, Exception b) throws TestFailedException {
        boolean failed = (a.getCause().getClass() != b.getCause().getClass());
        
        if (failed) {
            throw new TestFailedException("Exception class difference: " + a.getCause().getClass() + " != " + b.getCause().getClass());
        }
    }
}
