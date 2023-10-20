public class ColorUtils {
    public static String formatBackgroundColorString(String background, String s) {
        return background + s + AsciiColorCode.RESET_COLOR;
    }

    public static String formatForegroundColorString(String foreground, String s) {
        return foreground + s + AsciiColorCode.RESET_COLOR;

    }

    public static String formatColorString(String background, String foreground, String s) {
        return foreground + background + s + AsciiColorCode.RESET_COLOR;
    }
}
