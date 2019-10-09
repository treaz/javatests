package com.horiaconstantin.ctci.arraysandstrings;

public class StringCompression {

    static String solutionWithPrevious(String input) {
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        char previous = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (previous == input.charAt(i)) {
                counter++;
            } else {
                sb.append(previous)
                        .append(counter);
                counter = 1;
                previous = input.charAt(i);
            }
        }
        sb.append(previous)
                .append(counter);
        return sb.toString().length() < input.length() ? sb.toString() : input;
    }

    // in wonder is this works for input = "a"
    static String solutionWithNext(String input) {
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for (int i = 0; i < input.length(); i++) {
            if (i + 1 >= input.length()) {
                sb.append(input.charAt(i)).append(counter);
                continue;
            }
            if (input.charAt(i) == input.charAt(i + 1)) {
                counter++;
            } else {
                sb.append(input.charAt(i)).append(counter);
                counter = 1;
            }
        }


        return sb.toString().length() < input.length() ? sb.toString() : input;
    }
}
