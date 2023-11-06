import java.io.File;
import java.util.List;

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

    /**
     * Enum that contains "invalid" Strings.
     */
    public enum StringInput {
        NULL(null),
        EMPTY(""),
        BLANK("   ");

        private final String stringValue;

        private StringInput(String stringValue) {
            this.stringValue = stringValue;
        }

        public String getStringValue() {
            return this.stringValue;
        }
    }

    /**
     * Interface to allow lambda function-like functionality with Strings
     */
    public interface StringFunction {
        String run(String str);
    }

    public static void deleteFile(String path) {
        File file = new File(path);
        file.delete();
    }
}
