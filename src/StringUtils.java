public class StringUtils {
    public static final String HORIZONTAL_LINE_CHARACTER = "\u2500";
    public static final int HORIZONTAL_LINE_LENGTH = 48;
    
    public static void printHorizontalLine() {
        System.out.println(String.format("%0" + HORIZONTAL_LINE_LENGTH + "d", 0).replace("0", HORIZONTAL_LINE_CHARACTER));
    }

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
