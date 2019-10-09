package com.horiaconstantin.ctci.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsPalindromePermutationTest {

    @Test
    void solutionWithBitOps() {
        assertTrue(IsPalindromePermutation.solutionWithBitOps("abcab"));
        assertTrue(IsPalindromePermutation.solutionWithBitOps("abcabc"));
        assertTrue(IsPalindromePermutation.solutionWithBitOps("aabbcc"));
        assertTrue(IsPalindromePermutation.solutionWithBitOps("cbbaa"));
        assertTrue(IsPalindromePermutation.solutionWithBitOps("c"));
        assertTrue(IsPalindromePermutation.solutionWithBitOps("aa"));

        assertFalse(IsPalindromePermutation.solutionWithBitOps("aaab"));
        assertFalse(IsPalindromePermutation.solutionWithBitOps("asdfghjk"));
    }
}