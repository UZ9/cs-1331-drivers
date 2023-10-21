/**
 * A custom exception used for detecting tests failed.
 */
class TestFailedException extends Exception {
    public TestFailedException() {
    }

    public TestFailedException(String message) {
        super(message);
    }
}
