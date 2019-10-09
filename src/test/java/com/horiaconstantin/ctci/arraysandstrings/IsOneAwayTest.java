package com.horiaconstantin.ctci.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsOneAwayTest {

    @Test
    void solution() {
        assertThrows(RuntimeException.class, () -> IsOneAway.solution("pale", "p"));

        assertTrue(IsOneAway.solution("pale", "ple"));
        assertTrue(IsOneAway.solution("aacc", "aaacc"));
        assertTrue(IsOneAway.solution("aaacc", "aacc"));
        assertTrue(IsOneAway.solution("pales", "pale"));
        assertTrue(IsOneAway.solution("pale", "pales"));
        assertTrue(IsOneAway.solution("ales", "pales"));
        assertTrue(IsOneAway.solution("pales", "ales"));
        assertTrue(IsOneAway.solution("pale", "bale"));
        assertTrue(IsOneAway.solution("p", "p"));
        assertTrue(IsOneAway.solution("", ""));
        assertTrue(IsOneAway.solution("", "s"));
        assertTrue(IsOneAway.solution(" ", ""));

        assertFalse(IsOneAway.solution("pale", "bake"));
    }
}