package com.horiaconstantin.ctci.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCompressionTest {

    @Test
    void solutionWIthPrevious() {

        assertEquals("a2b1c5a3", StringCompression.solutionWithPrevious("aabcccccaaa"));
        assertEquals("ab", StringCompression.solutionWithPrevious("ab"));
        assertEquals("a", StringCompression.solutionWithPrevious("a"));
    }

    @Test
    void solutionWithNext() {

//        assertEquals("a2b1c5a3", StringCompression.solutionWithNext("aabcccccaaa"));
//        assertEquals("ab", StringCompression.solutionWithNext("ab"));
        assertEquals("a", StringCompression.solutionWithNext("a"));
    }
}