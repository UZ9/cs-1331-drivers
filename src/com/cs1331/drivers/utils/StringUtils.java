package com.cs1331.drivers.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.cs1331.drivers.exception.TestFailedException;

public class StringUtils {
    /**
     * The ASCII character to use for horizontal lines
     */
    public static final String HORIZONTAL_LINE_CHARACTER = "\u2500";

    /**
     * The amount of HORIZONTAL_LINE_CHARACTER elements to use in a line
     */
    public static final int HORIZONTAL_LINE_LENGTH = 64;

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
     * Utility for converting a Throwable to a stack trace string.
     * 
     * @param e Exception to print the stacktrace of
     * @return The formatted stack trace
     */
    public static String stackTraceToString(Throwable e) {
        StackTraceElement[] stackTrace = e.getStackTrace();

        if (stackTrace.length == 0) {
            return "No stack trace.";
        }

        StringBuilder sb = new StringBuilder(stackTrace[0].toString());
        for (int i = 1; i < stackTrace.length; i++) {
            sb.append("\n\t");
            sb.append(stackTrace[i].toString());
        }
        return sb.toString();
    }

    /**
     * Converts an arraylist into a readable string.
     * @param inputs the input arraylist
     * @return the arraylist as a string
     * @throws TestFailedException if the method was unable to convert the arraylist
     */
    public static String arrayListToString(ArrayList<?> inputs) throws TestFailedException {
        return arrayToString(inputs.toArray(), ",");
    }

    /**
     * Returns the Array as a String using the toString() method of each item.
     * The resulting String has an itemSeparator between each element.
     * @param inputs The Array to convert to String.
     * @param itemSeparator The String to put BETWEEN each item.
     * @return the array as a string
     */
    public static String arrayToString(Object[] inputs, String itemSeparator) throws TestFailedException {
        if (inputs.length == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        for (Object input : inputs) {
            builder.append(input == null ? "null" : input.toString()).append(itemSeparator);
        }

        return builder.toString();
    }

    public static String arrayToString(Object[] inputs) throws TestFailedException {
        return arrayToString(inputs, ",");
    }

    /**
     * Reads the contents of a file and converts it into a string,
     * using \n as the delimiter.
     * @param path the path to the file
     * @return the file's contents as a string
     * @throws FileNotFoundException if the file cannot be found
     */
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
     * @throws FileNotFoundException if the file cannot be found
     */
    public static void stringToFile(String path, String data) throws FileNotFoundException {

        PrintWriter writer = new PrintWriter(path);

        writer.write(data);

        writer.close();

    }

    /**
     * Returns a modified version of 'actual', where the first character that
     * differs from 'expected' is highlighted RED.
     * 
     * @param actual   The 'actual' String
     * @param expected The 'expected' String to compare against
     * @return The string showing the color coded difference.
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
            output.append(formatSingleLine(split[i])).append("\n");
        }

        output.append(formatSingleLine(split[split.length - 1]));

        return output + "\n";
    }

    private static String formatSingleLine(String s) {
        int currentLength = 0;

        StringBuilder builder = new StringBuilder("\t" + s);

        while (currentLength + HORIZONTAL_LINE_LENGTH < builder.length()
                && (currentLength = builder.indexOf(" ", currentLength + HORIZONTAL_LINE_LENGTH)) != -1) {
            
            builder.replace(currentLength, currentLength + 1, "\n\t");
        }

        return builder.toString();
    }
}
