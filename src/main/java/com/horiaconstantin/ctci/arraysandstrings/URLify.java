package com.horiaconstantin.ctci.arraysandstrings;

import lombok.NonNull;

import java.util.Arrays;

public class URLify {

    static String solutionWithReplace(String input) {
        return input.replace(" ", "%20");
    }

    /**
     * Performance O(n)
     */
    static String solutionWithInPlaceArrayReplace(char[] chars, int stringLength) {
        int index = chars.length - 1;
        for (int i = stringLength - 1; i >= 0; i--) {
            char current = chars[i];
            if (current != ' ') {
                chars[index] = current;
                index--;
            } else {
                chars[index] = '0';
                chars[index - 1] = '2';
                chars[index - 2] = '%';
                index = index - 3;
            }
        }

        return new String(chars);
    }

    /**
     * O(n)
     */
    static String solutionWithInPlaceArrayReplace(@NonNull String input) {
        int spaceCount = 0;
        char[] trimmed = input.trim().toCharArray();
        for (char c : trimmed) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        char[] newInput = Arrays.copyOf(trimmed, trimmed.length + spaceCount * 2);

        return solutionWithInPlaceArrayReplace(newInput, trimmed.length);// O(n)

    }
}
