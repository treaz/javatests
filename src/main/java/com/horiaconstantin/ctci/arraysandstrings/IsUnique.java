package com.horiaconstantin.ctci.arraysandstrings;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
class IsUnique {

    /**
     * Performance: O(n)
     * Handles all Unicode characters
     */
    static boolean solutionWithSet(@NonNull String input) {
        char[] chars = input.toCharArray();
        Set<String> characterSet = new HashSet<>(chars.length);
        StringBuilder character = new StringBuilder();
        for (Character c : chars) { // O(n)
            if (Character.isHighSurrogate(c)) {
                character.append(c);
                continue;
            } else {
                character.append(c);
            }
            if (!characterSet.add(character.toString())) { // O(1)
                log.info("Duplicate character: '{}'", character);
                return false;
            }
            character = new StringBuilder();
        }
        return true;
    }


    /**
     * This is a bad solution because of the space usage of it. The resulting array will be super sparse.
     * For Supplementary characters, the backing array would need to be of size Integer.max_value.
     * That will give an out of heap memory exception.
     *
     * @param input
     * @return true if unique
     */
    static boolean solutionWithArray(@NonNull String input) {
        boolean[] array = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < input.length(); i++) { //O(n)
            boolean val = array[input.codePointAt(i)];
            if (val) {
                return false;
            }
            array[input.codePointAt(i)] = true;
        }
        return true;
    }

    /**
     * this implementation only support BMP Chars. Supplementary Characters occupy 2 chars in the char array.
     * Performance: O(n*logn)
     *
     * @param input
     * @return
     */
    static boolean solutionWithSort(@NonNull String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);// O(n*logn)
        char previous = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (previous != chars[i]) {
                previous = chars[i];
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Implemented because it's fun
     * Performance: O(n)
     *
     * @param input assuming only lowercase letters
     * @return
     */
    static boolean solutionWithBitwiseOps(@NonNull String input) {
        int checker = 0;
        for (int i = 0; i < input.length(); i++) { //O(n)
            char c = input.charAt(i);
            if (Character.isLowerCase(c) || Character.isLetter(c)) {
                int diff = c - 'a';
                if ((checker & (1 << diff)) > 0) {
                    return false;
                }
                checker = checker | (1 << diff);
            } else {
                throw new RuntimeException("Found not valid character: " + c);
            }
        }
        return true;
    }
}
