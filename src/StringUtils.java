public class StringUtils {
    public static final String HORIZONTAL_LINE_CHARACTER = "\u2500";
    public static final int HORIZONTAL_LINE_LENGTH = 48;
    
    public static void printHorizontalLine() {
        System.out.println(String.format("%0" + HORIZONTAL_LINE_LENGTH + "d", 0).replace("0", HORIZONTAL_LINE_CHARACTER));
    }
}
