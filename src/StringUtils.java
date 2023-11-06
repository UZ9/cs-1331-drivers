import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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

    public static String arrayListToString(ArrayList<? extends Object> inputs) {
        if (inputs.size() == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder(inputs.get(0).toString());

        for (int i = 1; i < inputs.size(); i++) {
            builder.append("\n" + inputs.get(i).toString());
        }

        return builder.toString();
    }

    public static String fileToString(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));

        String output = "";

        while (scanner.hasNextLine()) {
            output += scanner.nextLine() + "\n";
        }

        output = output.substring(0, output.length() - 1); //Removes the trailing newline that did not exist in the original file

        scanner.close();

        return output;
    }

    /**
     * Prints the given String to the file at the path.
     * THIS METHOD WILL OVERWRITE ANY DATA.
     * @param path Path to write at.
     * @param data Data to write to the file.
     * @throws FileNotFoundException
     */
    public static void stringToFile(String path, String data) throws FileNotFoundException {

        PrintWriter writer = new PrintWriter(path);

        writer.write(data);

        writer.close();

    }
}
