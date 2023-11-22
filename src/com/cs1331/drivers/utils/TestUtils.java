package com.cs1331.drivers.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;

public class TestUtils {

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

        try {
            Files.delete(file.toPath());
        } catch (FileSystemException e) {

            if (e.getMessage().contains("used by another process")) {
                System.out.println(ColorUtils.formatColorString(AsciiColorCode.BRIGHT_YELLOW_BACKGROUND,
                        AsciiColorCode.BRIGHT_WHITE_FOREGROUND, " DELETE FILE ERROR: \u00BB ")
                        + " The program failed to delete " + file.getName() + ". Although this will not change the outcome of the tests, to solve this issue you must ensure ALL of your scanners have been properly closed, INCLUDING during an exception. This has only been recorded on Windows machines, but feel free to reach out if you encounter the issue!");

            }
        } catch (IOException ignored) {
        }
    }

    /**
     * Converts the given Iterable to String by calling the toString() method of each
     * element in the iterator, in the order given, with commas (but no spaces) between
     * each element.
     * @param iterable The Iterable object to be converted to String.
     * @return The combined String, in the aforementioned format.
     */
    public static String iterableToString(Iterable<?> iterable) {
        Iterator<?> iterator = iterable.iterator();
        if (!iterator.hasNext()) { // If the iterator is empty, then return nothing
            return "";
        }
        
        StringBuilder builder = new StringBuilder();
        builder.append(iterator.next().toString());
        
        while (iterator.hasNext()) {
            builder.append("," + iterator.next().toString());
        }

        return builder.toString();
    }
}
