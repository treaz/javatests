package com.horiaconstantin.javatests.io;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LineStats {

    Map<Character, Integer> delimStats = new HashMap<Character, Integer>();
    Map<Character, Integer> nonDelimStats = new HashMap<Character, Integer>();
    Character lastChar;
    boolean escapes;
    Character firstDelim;

    public LineStats(String line) {
        this(line, null);
    }

    /**
     * @param line              the line to evaluate
     * @param suppliedDelimiter the explicit delimiter supplied by the user, or null if not defined
     */
    public LineStats(String line, final Character suppliedDelimiter) {
        // Look for delimiters
        char[] chars = line.toCharArray();
        String delimiterString = " :;|\t+";
        String nonDelimiterString = "\"'<>\\";

        if (suppliedDelimiter != null) {
            delimiterString += Character.toString(suppliedDelimiter);
        }

        char[] delimiters = delimiterString.toCharArray();
        char[] nonDelimiters = nonDelimiterString.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            boolean found = false;
            for (char delim : delimiters) {
                if (c == delim) {
                    increment(delim, true);
                    found = true;
                    break;
                }
            }
            if (!found) {
                for (char delim : nonDelimiters) {
                    if (c == delim) {
                        increment(delim, false);
                        break;
                    }
                }
            }
        }
    }

    boolean containsNoDelimCharOfType(Character quoteType) {
        Integer count = nonDelimStats.get(quoteType);
        return (count != null);
    }

    boolean hasLegalQuotedStringOfChar(Character quoteType) {
        Integer count = nonDelimStats.get(quoteType);
        return (count == null || count.intValue() % 2 == 0);
    }

    void increment(Character c, boolean delim) {
        if (delim) {
            if (lastChar == null || (lastChar != '\\') || (lastChar == '\\' && c == '\\')) {
                Integer val = delimStats.get(c);
                val = (val == null ? 1 : val.intValue() + 1);
                if (val == 1) {
                    firstDelim = c;
                }
                delimStats.put(c, val);
            } else {
                escapes = true;
            }
        } else {
            Integer val = nonDelimStats.get(c);
            val = (val == null ? 1 : val.intValue() + 1);
            nonDelimStats.put(c, val);
        }
        lastChar = c;
    }

    public Map<Character, Integer> calcDelimCountsOrdered() {
        return sortMapByValue(delimStats);
    }

    private static <K, V extends Comparable<? super V>> Map<K, V> sortMapByValue(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

}
