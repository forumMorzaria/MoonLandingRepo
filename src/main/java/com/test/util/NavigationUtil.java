package com.test.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author forum
 * @since 23-10-2020.
 */
public class NavigationUtil {

    public static int getIntFromSpaceSeparatedStringAt(String s, int index) {
        try {
            return Integer.parseInt(getValueFromSpaceSeparatedStringAt(s, index));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Incorrect input");
        }
    }

    public static String getValueFromSpaceSeparatedStringAt(String s, int index) {
        return s.split(" ")[index];
    }

    public static void validateInput(String input, Pattern p, String message) {
        Matcher matcher = p.matcher(input);
        if(!matcher.matches()) {
            System.err.println(message);
            System.exit(1);
        }
    }
}
