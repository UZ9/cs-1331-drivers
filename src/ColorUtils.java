public class ColorUtils {
    /**
     * Formats a string to have an ASCII background in terminal.
     * 
     * @param background The ASCII representation of the background color, pulled
     *                   from AsciiColorCode
     * @param s          The string to color
     * @return The colored string
     */
    public static String formatBackgroundColorString(String background, String s) {
        return background + s + AsciiColorCode.RESET_COLOR;
    }

    /**
     * Formats a string to have an ASCII foreground (text color) in terminal.
     * 
     * @param foreground The ASCII representation of the foreground color, pulled
     *                   from AsciiColorCode
     * @param s          The string to color
     * @return The colored string
     */
    public static String formatForegroundColorString(String foreground, String s) {
        return foreground + s + AsciiColorCode.RESET_COLOR;

    }

    /**
     * Formats a string to have both an ASCII foreground and background in terminal
     * 
     * @param background The ASCII representation of the background color, pulled
     *                   from AsciiColorCode
     * @param foreground The ASCII representation of the foreground color, pulled
     *                   from AsciiColorCode
     * @param s          The string to color
     * @return The colored string
     */
    public static String formatColorString(String background, String foreground, String s) {
        return foreground + background + s + AsciiColorCode.RESET_COLOR;
    }
}
