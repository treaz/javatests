package com.horiaconstantin.googletechdevguide.foundations;

import lombok.NonNull;

public class WordIsInSequenceNaiveImproved implements WordIsInSequence {


    /**
     * Performance: O(N*M), n is word size and m is sequence size
     */
    @Override
    public boolean solution(@NonNull String word, @NonNull String sequence) {
        if (word.length() == 0 || word.length() > sequence.length()) {
            return false;
        }
        char[] wChars = word.toCharArray();
        char[] sChars = sequence.toCharArray();

        int wCharIndex = 0;
        int wordCharInSeqIndex = 0;
        while (wCharIndex < wChars.length) {
            int sCharIndex = wordCharInSeqIndex;
            while (sCharIndex < sChars.length) {
                if (wChars[wCharIndex] == sChars[sCharIndex]) {
                    wordCharInSeqIndex = sCharIndex;
                    break;
                }
                sCharIndex++;
                if (sCharIndex == sChars.length - 1) {
                    return false;
                }
            }
            wCharIndex++;
        }

        return true;
    }
}
