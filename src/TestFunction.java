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
    public static void assertEqual(int received, int expected) throws TestFailedException {
        boolean failed = (received != expected);
        if (failed) {
            throw new TestFailedException("Integer value difference: Received " + received + ", expected " + expected);
        }
    }

    /**
     * Detects if the given doubles are not within 1.0e-6 of one another.
     * @param received
     * @param expected
     * @throws TestFailedException
     */
    public static void assertEqual(double received, double expected) throws TestFailedException {
        final double ALLOWABLE_ERROR = 0.000001;

        boolean failed = (Math.abs(received - expected) > ALLOWABLE_ERROR);

        if (failed) {
            throw new TestFailedException("Double value difference: Received " + received + ", expected " + expected);
        }
    }

    /**
     * Detects if the given booleans do not have equal values.
     * @param received
     * @param expected
     * @throws TestFailedException
     */
    public static void assertEqual(boolean received, boolean expected) throws TestFailedException {
        boolean failed = (received != expected);

        if (failed) {
            throw new TestFailedException("Boolean value difference: Received " + received + ", expected " + expected);
        }
    }

    /**
     * Detects if the given Exceptions are the same TYPE, not if they are caused by the same thing. Any two
     * NullPointerExceptions will, when passed into this function, return true, even if they are cuased by
     * two unrelated issues.
     * @param received
     * @param expected
     * @throws TestFailedException
     */
    public static void assertEqual(Exception received, Exception expected) throws TestFailedException {
        boolean failed = (received.getCause().getClass() != expected.getCause().getClass());
        
        if (failed) {
            throw new TestFailedException("Exception class difference: Received " + received.getCause().getClass() + ", but expected " + expected.getCause().getClass());
        }
    }
}
