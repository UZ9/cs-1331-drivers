class StringUtils {
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

        System.out.printf("%" + (HORIZONTAL_LINE_LENGTH / 2 + text.length() / 2) + "s%n", text);
    }

    /**
     * Util that a stack trace into a printable string.
     * @param e Exception to print the stacktrace of
     * @return
     */
    public static String stackTraceToString(Throwable e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        
        if (stackTrace.length == 0) {
            return "No stack trace.";
        }

        StringBuilder sb = new StringBuilder(stackTrace[0].toString());
        for (int i = 1; i < stackTrace.length; i++) {
            sb.append("\n    ");
            sb.append(stackTrace[i].toString());
        }
        return sb.toString();
    }
}
