package com.cs1331.drivers.exception;
/**
 * A custom exception used for detecting tests failed.
 */
public class TestFailedException extends Exception {
    public TestFailedException() {
    }

    public TestFailedException(String message) {
        super(message);
    }
}
