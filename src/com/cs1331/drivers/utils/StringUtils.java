package com.cs1331.drivers.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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

        System.out.printf("%" + (HORIZONTAL_LINE_LENGTH / 2 + text.length() / 2) + "s%n", text);
    }

    /**
     * Util that a stack trace into a printable string.
     * 
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
        return arrayToString(inputs.toArray(), ",");
    }

    /**
     * Returns the Array as a String using the toString() method of each item.
     * The resulting String has an itemSeparator between each element.
     * @param inputs The Array to convert to String.
     * @param itemSeparator The String to put BETWEEN each item.
     * @return
     */
    public static String arrayToString(Object[] inputs, String itemSeparator) {
        if (inputs.length == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        for (Object input : inputs) {
            builder.append(input.toString()).append(itemSeparator);
        }

        return builder.toString();
    }

    public static String arrayToString(Object[] inputs) {
        return arrayToString(inputs, ",");
    }

    public static String fileToString(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));

        StringBuilder output = new StringBuilder();

        while (scanner.hasNextLine()) {
            String next = scanner.nextLine();

            output.append(next).append("\n");
        }

        scanner.close();

        return output.toString();
    }

    /**
     * Prints the given String to the file at the path.
     * THIS METHOD WILL OVERWRITE ANY DATA.
     * 
     * @param path Path to write at.
     * @param data Data to write to the file.
     * @throws FileNotFoundException
     */
    public static void stringToFile(String path, String data) throws FileNotFoundException {

        PrintWriter writer = new PrintWriter(path);

        writer.write(data);

        writer.close();

    }

    /**
     * Returns a modified version of 'actual', where the first character that
     * differs from
     * 'expected' is highlighted RED.
     * 
     * @param actual   The 'actual' String
     * @param expected The 'expected' String to compare against
     * @return
     */
    public static String getColorCodedDifference(String actual, String expected) {
        StringBuilder colored = new StringBuilder();
        for (int i = 0; i < actual.length(); i++) {
            char actualChar = actual.charAt(i);

            if (expected.length() <= i) {
                colored.append(actual.substring(i));
                break;
            }

            if (actualChar == expected.charAt(i)) {
                colored.append(actual.charAt(i));
            } else {
                colored.append(ColorUtils.formatColorString(AsciiColorCode.RED_BACKGROUND,
                        AsciiColorCode.WHITE_FOREGROUND, actualChar + ""));
                colored.append(actual.substring(i + 1));
                break;
            }

        }

        return colored.toString();

    }

    public static String formatIndented(String s) {
        String[] split = s.split("\n");

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < split.length - 1; i++) {
            output.append(formatSingleLine(split[i]) + "\n");
        }

        output.append(formatSingleLine(split[split.length - 1]));

        return output.toString() + "\n";
    }

    private static String formatSingleLine(String s) {
        int currentLength = 0;

        StringBuilder builder = new StringBuilder("\t" + s);

        while (currentLength + HORIZONTAL_LINE_LENGTH < builder.length()
                && (currentLength = builder.lastIndexOf(" ", currentLength + HORIZONTAL_LINE_LENGTH)) != -1) {
            
            builder.replace(currentLength, currentLength + 1, "\n\t");
        }

        return builder.toString();
    }
}
