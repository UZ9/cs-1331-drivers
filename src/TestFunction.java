import java.util.List;
import java.util.function.Consumer;

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
            if (expected != null) {
                throw new TestFailedException("Test failed! Received null, but expected \"" + expected + "\"");
            }
        } else if (expected == null) {
            throw new TestFailedException("Test failed! Received \"" + actual + "\", but expected null");
        } else {

            if (!actual.replaceAll("\n", System.lineSeparator()).equals(expected.replaceAll("\n", System.lineSeparator()))) {
                failed = true;
            }
        }

        if (failed) {
            
            
            String expectedString = "\"" + expected + "\"";
            String coloredActual = StringUtils.getColorCodedDifference("\"" + actual + "\"", expectedString);

            
            if (coloredActual.trim().contains("\n")) {
                coloredActual = "\n" + coloredActual + "\n";
            }
            if (expected.trim().contains("\n")) {
                expectedString = "\n\"" + expected + "\"\n";
            }

            throw new TestFailedException(
                    "Strings different! Received " + coloredActual + " but expected " + expectedString);
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
            throw new TestFailedException("Double value difference: \n\tReceived " + actual + ", expected " + expected);
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
     * Detects if the given objects are equal by their .equals() methods. By default, this method will also test
     * for symmetry.
     *
     * @param expected Whether or not these two objects should be equal by their .equals() methods
     * @param obj1 The first object to compare.
     * @param obj2 The second object to compare.
     * @throws TestFailedException if the test fails
     */
    public static void assertEqual(boolean expected, Object obj1, Object obj2) throws TestFailedException {
        boolean actual = obj1.equals(obj2);
        if (actual != expected) {
            throw new TestFailedException("Boolean value difference with .equals() method. When comparing\n\"" + obj1.toString() + "\" with \"" + obj2.toString() + "\", Received " + actual + ", expected " + expected);
        }

        if (actual != obj2.equals(obj1)) {
            throw new TestFailedException("Asymmetry detected! When comparing \"" + obj1.toString() + "\" with \"" + obj2.toString() + "\", Received " + actual + ". But when calling .equals() the other way, received " + !actual);
        }
    }

    /**
     * Tests the given code for a particular type of Exception.
     * @param exceptionType The class of the expected Exception.
     * @param codeThatThrowsException Runnable code that is intended to throw an exceptino of type exceptionType. Must NOT throw a TestFailedException
     * @throws TestFailedException
     */
    public static void testForException(Class<? extends Exception> exceptionType, Runnable codeThatThrowsException) throws TestFailedException {
        try {
            codeThatThrowsException.run();
            throw new TestFailedException(exceptionType.getSimpleName() + " did NOT occur when it was supposed to!");
        } catch (Exception e) {
            if (e.getClass() == exceptionType) {
                // Test passed! Finish running method and return to the invoker
            } else if (e.getClass() == TestFailedException.class && e.getMessage().contains("did NOT occur")) {

                throw new TestFailedException("No exception occurred! The code should have thrown a " + exceptionType.getSimpleName());

            } else {

                throw new TestFailedException("Exception class difference! Received " + e.getClass().getSimpleName() + " but expected " + exceptionType.getSimpleName() + "."
                    + "\nFull stack trace:\n" + StringUtils.stackTraceToString(e));

            }
        }
    }

    /**
     * Tester for String inputs. Takes in a String -> String function, and compares the output with the desired output.
     * @param actual The expected String output of the runnable function.
     * @param codeToRun A runnable function that takes in a String and outputs a String.
     * @param inputs The StringInput values to test.
     * @throws TestFailedException
     */
    public static void testStringInputs(String actual, TestUtils.StringFunction codeToRun, TestUtils.StringInput[] inputs) throws TestFailedException {

        for (TestUtils.StringInput stringInput : inputs) {
            try {
                assertEqual(actual, codeToRun.run(stringInput.getStringValue()));
            } catch (TestFailedException tfe) {
                throw new TestFailedException("When inputted string is " + stringInput.toString() + ": " + tfe.getMessage());
            }
        }

    }

    /**
     * Convenience method that calls testStringInputs(String, StringFunction, StringInput[]) for ALL
     * values of the StringFunction enum.
     * @param actual The expected String output of the runnable function.
     * @param codeToRun A runnable function that takes in a String and outputs a String.
     * @throws TestFailedException
     */
    public static void testStringInputs(String actual, TestUtils.StringFunction codeToRun) throws TestFailedException {
        testStringInputs(actual, codeToRun, TestUtils.StringInput.values());
    }

    /**
     * Tester for String inputs. Takes in a String -> String function, and compares the output with the desired output.
     * @param actual The expected String output of the runnable function.
     * @param codeToRun A runnable function that takes in a String and outputs a String.
     * @param inputs The StringInput values to test.
     * @throws TestFailedException
     */
    public static void testStringInputsForException(Class<? extends Exception> exceptionType, Consumer<String> codeToRun, TestUtils.StringInput... inputs) throws TestFailedException {

        for (TestUtils.StringInput stringInput : inputs) {
            try {
                testForException(exceptionType, () -> codeToRun.accept(stringInput.getStringValue()));
            } catch (TestFailedException tfe) {
                throw new TestFailedException("When inputted string is " + stringInput.toString() + ": " + tfe.getMessage());
            }
        }

    }

    /**
     * Convenience method that calls testStringInputs(String, StringFunction, StringInput[]) for ALL
     * values of the StringFunction enum.
     * @param actual The expected String output of the runnable function.
     * @param codeToRun A runnable function that takes in a String and outputs a String.
     * @throws TestFailedException
     */
    public static void testStringInputsForException(Class<? extends Exception> exceptionType, Consumer<String> codeToRun) throws TestFailedException {
        testStringInputsForException(exceptionType, codeToRun, TestUtils.StringInput.values());
    }

    /**
     * Prints an error message
     *
     * @param actual   The actual value
     * @param expected The expected value
     * @throws TestFailedException If the test fails
     */
    public static void failTest(String errorMessage) throws TestFailedException {
        throw new TestFailedException("An error occurred: " + errorMessage);
    }

}
