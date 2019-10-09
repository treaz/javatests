package com.horiaconstantin.ctci.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class URLifyTest {

    @Test
    void solutionWithInPlaceArrayReplace() {
        assertEquals("I%20am%20home", URLify.solutionWithInPlaceArrayReplace("I am home    ".toCharArray(), 9));
        assertEquals("Mr%20John%20Smith", URLify.solutionWithInPlaceArrayReplace("Mr John Smith    ".toCharArray(), 13));
        assertEquals("Mr%20John%20Smith", URLify.solutionWithInPlaceArrayReplace("Mr John Smith"));
        assertEquals("Mr%20John%20Smith", URLify.solutionWithInPlaceArrayReplace("Mr John Smith\n    \n"));
    }
}