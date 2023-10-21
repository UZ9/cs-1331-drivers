import java.util.List;

class TestUtils {
    public static void printDebug(String s) {
        System.out.println("DEBUG: " + s);
    }

    /**
     * Returns either 1, 0, or -1 depending on the sign of the input.
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

    public static String combinePrintStatements(List<String> printedMessages) {
        if (printedMessages == null || printedMessages.size() == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder(printedMessages.get(0));
        for (int i = 1; i < printedMessages.size(); i++) {
            builder.append("\n");
            builder.append(printedMessages.get(i));
        }
        return builder.toString();
    }
}
