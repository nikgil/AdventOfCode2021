package com.github.nikgil.utils;

public class StringUtils {

    private StringUtils() {}

    public static String toLowerCase(String in) {
        StringBuilder sb = new StringBuilder();

        for(char c : in.toCharArray()) {
            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    public static String toUpperCase(String in) {
        StringBuilder sb = new StringBuilder();

        for(char c : in.toCharArray()) {
            sb.append(Character.toUpperCase(c));
        }

        return sb.toString();
    }
}
