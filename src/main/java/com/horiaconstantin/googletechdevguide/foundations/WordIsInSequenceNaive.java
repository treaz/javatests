package com.horiaconstantin.googletechdevguide.foundations;

import com.google.common.collect.Lists;
import com.google.common.primitives.Chars;
import lombok.NonNull;

import java.util.Deque;

public class WordIsInSequenceNaive implements WordIsInSequence {


    /**
     * Performance: O(n*m), n is word size and m is sequence size
     */
    @Override
    public boolean solution(@NonNull String word, @NonNull String sequence) {
        if (word.length() == 0 || word.length() > sequence.length()) {
            return false;
        }
        Deque<Character> wChars = Lists.newLinkedList(Chars.asList(word.toCharArray()));
        Deque<Character> sChars = Lists.newLinkedList(Chars.asList(sequence.toCharArray()));

        Character wChar = wChars.pollFirst();
        while (wChar != null) {
            Character sChar = sChars.pollFirst();
            while (sChar != null) {
                if (wChar.equals(sChar)) {
                    break;
                }
                sChar = sChars.pollFirst();
                if (sChar == null) {
                    return false;
                }
            }
            wChar = wChars.pollFirst();
        }

        return true;
    }
}
