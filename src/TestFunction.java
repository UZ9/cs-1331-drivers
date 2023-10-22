import java.util.List;

class TestFunction {
    /**
     * Detects if the given Strings do not have the same content (case-sensitive)
     *
     * @param actual   The actual value
     * @param expected The expected value
     * @throws TestFailedException if the test fails
     */
    public static void assertEqual(String actual, String expected) throws TestFailedException {
        boolean failed = false;

        if (actual == null) {
            failed = expected == null;
        } else {

            if (!actual.replaceAll("\n", System.lineSeparator()).equals(expected.replaceAll("\n", System.lineSeparator()))) {
                failed = true;
            }
        }

        if (failed) {
            
            String actualString = "\"" + actual + "\" ";
            String expectedString = "\"" + expected + "\"";
            
            if (actual.trim().contains("\n")) {
                actualString = "\n\"" + actual + "\"\n";
            }
            if (expected.trim().contains("\n")) {
                expectedString = "\n\"" + expected + "\"\n";
            }

            throw new TestFailedException(
                    "Strings different! Received " + actualString + "but expected " + expectedString);
        }
    }

    public static void assertEqual(List<String> actual, List<String> expected) throws TestFailedException {
        boolean failed = false;

        if (actual == null || expected == null || actual.size() != expected.size()) {
            failed = actual == expected;
        } else {
            for (int i = 0; i < expected.size(); i++) {
                if (expected.get(i) == null) {
                    failed = actual.get(i) != null;

                } else {
                    failed = !actual.get(i).equals(expected.get(i));

                }
                if (failed) break;
            }
        }

        if (failed) {
            throw new TestFailedException(
                    "List Different! Received \"" + actual + "\", expected \"" + expected + "\"");
        }
    }

    /**
     * Detects if the given integers are not equal.
     *
     * @param actual   The actual value
     * @param expected The expected value
     * @throws TestFailedException if the test fails
     */
    public static void assertEqual(int actual, int expected) throws TestFailedException {
        boolean failed = (actual != expected);
        if (failed) {
            throw new TestFailedException("Integer value difference: Received " + actual + ", expected " + expected);
        }
    }

    /**
     * Detects if the given doubles are not within 1.0e-6 of one another.
     *
     * @param actual   The actual value
     * @param expected The expected value
     * @throws TestFailedException if the test fails
     */
    public static void assertEqual(double actual, double expected) throws TestFailedException {
        final double ALLOWABLE_ERROR = 0.000001;

        boolean failed = (Math.abs(actual - expected) > ALLOWABLE_ERROR);

        if (failed) {
            throw new TestFailedException("Double value difference: Received " + actual + ", expected " + expected);
        }
    }

    /**
     * Detects if the given booleans do not have equal values.
     *
     * @param actual   The actual value
     * @param expected The expected value
     * @throws TestFailedException if the test fails
     */
    public static void assertEqual(boolean actual, boolean expected) throws TestFailedException {
        boolean failed = (actual != expected);

        if (failed) {
            throw new TestFailedException("Boolean value difference: Received " + actual + ", expected " + expected);
        }
    }

    /**
     * Detects if the given Exceptions are the same TYPE, not if they are caused by
     * the same thing. Any two
     * NullPointerExceptions will, when passed into this function, return true, even
     * if they are caused by
     * two unrelated issues.
     *
     * @param actual   The actual value
     * @param expected The expected value
     * @throws TestFailedException If the test fails
     */
    public static void assertEqual(Exception actual, Exception expected) throws TestFailedException {
        boolean failed = (actual.getCause().getClass() != expected.getCause().getClass());

        if (failed) {
            throw new TestFailedException("Exception class difference: Received " + actual.getCause().getClass()
                    + ", but expected " + expected.getCause().getClass());
        }
    }
}
