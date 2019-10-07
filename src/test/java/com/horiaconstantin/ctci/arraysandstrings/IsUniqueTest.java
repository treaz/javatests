package com.horiaconstantin.ctci.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsUniqueTest {
    private String inputWithUniqueBMPChars = "abcde€";
    private String inputWithDoubleBMPChars = "abcde€€";
    private static final String RANDOM_ASCII = "1qwsdfgvbnm,l.;'[]=-0oikj";
    private static final String RANDOM_LOWERCASE = "qasxcvbhjkiongfre";
    private static final String RANDOM_DUPLICATE_LOWERCASE = "qasxcvbhjkioyangfre";

    @Test
    void solutionWithSet() {
        String suppChar1 = new String(Character.toChars(0x2F81A));//冬
        String suppChar2 = new String(Character.toChars(0x2F818)); //冤
        String suppChar3 = "\uD801\uDC00"; //𐐀

        String inputWithDoubleSupplementalChars = "abc" + suppChar3 + "de" + suppChar3;
        assertFalse(IsUnique.solutionWithSet(inputWithDoubleSupplementalChars));

        String inputWithUniqueSupplementalChars = "abcde" + suppChar1 + suppChar2;
        assertTrue(IsUnique.solutionWithSet(inputWithUniqueSupplementalChars));

        assertTrue(IsUnique.solutionWithSet(inputWithUniqueBMPChars));

        assertFalse(IsUnique.solutionWithSet(inputWithDoubleBMPChars));

        assertTrue(IsUnique.solutionWithSet(RANDOM_ASCII));
        assertTrue(IsUnique.solutionWithSet(RANDOM_LOWERCASE));
        assertFalse(IsUnique.solutionWithSet(RANDOM_DUPLICATE_LOWERCASE));

    }

    @Test
    void solutionWithArray() {
        assertTrue(IsUnique.solutionWithArray(inputWithUniqueBMPChars));

        assertFalse(IsUnique.solutionWithArray(inputWithDoubleBMPChars));

        assertTrue(IsUnique.solutionWithArray(RANDOM_ASCII));
        assertTrue(IsUnique.solutionWithArray(RANDOM_LOWERCASE));
        assertFalse(IsUnique.solutionWithArray(RANDOM_DUPLICATE_LOWERCASE));
    }

    @Test
    void solutionWithSort() {
        assertTrue(IsUnique.solutionWithSort(inputWithUniqueBMPChars));

        assertFalse(IsUnique.solutionWithSort(inputWithDoubleBMPChars));

        assertTrue(IsUnique.solutionWithSort(RANDOM_ASCII));

        assertTrue(IsUnique.solutionWithSort(RANDOM_LOWERCASE));
        assertFalse(IsUnique.solutionWithSort(RANDOM_DUPLICATE_LOWERCASE));
    }

    @Test
    void solutionWithBitwiseOps() {
        assertThrows(NullPointerException.class, () -> IsUnique.solutionWithBitwiseOps(null));
        assertThrows(RuntimeException.class, () -> IsUnique.solutionWithBitwiseOps(inputWithUniqueBMPChars));

        assertTrue(IsUnique.solutionWithBitwiseOps(RANDOM_LOWERCASE));
        assertFalse(IsUnique.solutionWithBitwiseOps(RANDOM_DUPLICATE_LOWERCASE));
    }
}