class TestUtils {
    /**
     * Returns either 1, 0, or -1 depending on the sign of the input.
     * 
     * @param input
     * @return -1 if input < 0, 0 if input = 0, 1 if input > 0
     */
    public static int signOf(int input) {
        if (input == 0) {
            return input;
        } else {
            return Math.abs(input) / input;
        }
    }
}
