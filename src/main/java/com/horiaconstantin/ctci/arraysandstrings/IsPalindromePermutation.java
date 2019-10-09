package com.horiaconstantin.ctci.arraysandstrings;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IsPalindromePermutation {

    /**
     * Only for lower case english alphabet. Implemented because it's an interesting way to work with bits
     * perf: O(n)
     */
    static boolean solutionWithBitOps(@NonNull String input) {
        char[] chars = input.toCharArray();
        int alphabetVector = 0;
        for (char aChar : chars) {
            int bitIndex = aChar - 'a';
            alphabetVector = toggle(alphabetVector, bitIndex);
        }
        log.debug(Integer.toBinaryString(alphabetVector));
        if (input.length() % 2 == 0) {
            return alphabetVector == 0;
        } else {
            // if there's only one bit set in alphabetVector, the "-1" will create a vector like ....1111.... When we "and" it with alphabetVector, it will result in 0
            return ((alphabetVector - 1) & alphabetVector) == 0;
        }
    }

    private static int toggle(int alphabetVector, int bitIndex) {
        int mask = 1 << bitIndex;
        //if adding the mask bit to the original vector doesn't change the vector,
        // it means that the bit was already turned on and we need to make it zero
        if ((mask | alphabetVector) == alphabetVector) {
            alphabetVector = mask ^ alphabetVector;
        } else {
            alphabetVector = mask | alphabetVector;
        }
        return alphabetVector;
    }
}
