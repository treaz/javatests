package com.horiaconstantin.ctci.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

public class IsOneAway {

    /**
     * Perf: O(n)
     */
    static boolean solution(String s1, String s2) {
        int lenience = 1;
        if (s1.length() == s2.length()) {
            return oneEditReplaceSimple(s1, s2, lenience);
        } else if (s1.length() + 1 == s2.length()) {
//            return checkStringsV2(s2, s1, lenience);
            return oneEditInsert(s2, s1);
        } else if (s1.length() == s2.length() + 1) {
//            return checkStringsV2(s1, s2, lenience);
            return oneEditInsert(s1, s2);
        } else {
            throw new RuntimeException("String differ in length by more than 1 character");
        }
    }

    private static boolean oneEditReplaceSimple(String s1, String s2, int lenience) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (diffCount > lenience) {
                return false;
            }
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
            }
        }
        return true;
    }

    private static boolean oneEditReplacewithMap(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            Integer val = map.getOrDefault(c, 0);
            map.put(c, val + 1);
        }
        for (char c : s2.toCharArray()) {
            Integer val = map.getOrDefault(c, 0);
            map.put(c, val - 1);
        }
        long nonZeroValueCount = map.values().stream().filter(val -> val != 0).count();
        return nonZeroValueCount <= 2;
    }

    // s1 is the longer string
    private static boolean checkStrings(String s1, String s2, int lenience) {
        int index = 0;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (i - index > lenience) {
                return false;
            }
            if (index == chars2.length) {

                return true;
            }
            if (chars1[i] == chars2[index]) {
                index++;
            }
        }
        return true;
    }

    // s1 is the longer string
    private static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0, index2 = 0;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index1++;

            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    // s1 is the longer string
    private static boolean checkStringsV2(String s1, String s2, int lenience) {
        int index = 0;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (i - index > 1) {
                return false;
            }
            if (index == chars2.length - 1) {
                return true;
            }
            if (chars1[i] == chars2[index]) {
                index++;
            }

        }
        return true;
    }
}
