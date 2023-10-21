public class StringUtils {
    /**
     * The ASCII character to use for horizontal lines
     */
    public static final String HORIZONTAL_LINE_CHARACTER = "\u2500";

    /**
     * The amount of HORIZONTAL_LINE_CHARACTER elements to use in a line
     */
    public static final int HORIZONTAL_LINE_LENGTH = 48;

    /**
     * Prints a horizontal line to the terminal.
     */
    public static void printHorizontalLine() {
        System.out
                .println(String.format("%0" + HORIZONTAL_LINE_LENGTH + "d", 0).replace("0", HORIZONTAL_LINE_CHARACTER));
    }

    /**
     * Prints centered text to the terminal.
     * 
     * @param text The text to be centered
     */
    public static void printTextCentered(String text) {
        // HORIZONTAL_LINE_LENGTH is maximum width
        // if line is
        // xxxxxxxxxxxx
        // We can pad the start of the string with half of the horizontal:
        // xxxxxhelloxx
        // The problem is that this doesn't account for the length of the string.
        // We can add half of the string length as well to correct it:
        // xxxxhelloxxxx = CENTERED! (or at least as close as it can get)

        System.out.println(String.format("%" + (HORIZONTAL_LINE_LENGTH / 2 + text.length() / 2) + "s", text));
    }
}
