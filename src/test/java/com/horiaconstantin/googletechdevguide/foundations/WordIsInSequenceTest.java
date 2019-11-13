package com.horiaconstantin.googletechdevguide.foundations;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordIsInSequenceTest {

    @ParameterizedTest
    @ValueSource(classes = {WordIsInSequenceNaive.class, WordIsInSequenceNaiveImproved.class})
    void wordInSequence(Class<WordIsInSequence> clazz) throws Exception {
        WordIsInSequence algo = clazz.getConstructor().newInstance();
        String word = "apple";
        String seq = "abppplee";

        assertTrue(algo.solution(word, seq));
    }

    @ParameterizedTest
    @ValueSource(classes = {WordIsInSequenceNaive.class, WordIsInSequenceNaiveImproved.class})
    void shortWordInSequence(Class<WordIsInSequence> clazz) throws Exception {
        WordIsInSequence algo = clazz.getConstructor().newInstance();
        String word = "ale";
        String seq = "abppplee";

        assertTrue(algo.solution(word, seq));
    }

    @ParameterizedTest
    @ValueSource(classes = {WordIsInSequenceNaive.class, WordIsInSequenceNaiveImproved.class})
    void wordNOTInSequence(Class<WordIsInSequence> clazz) throws Exception {
        WordIsInSequence algo = clazz.getConstructor().newInstance();
        String word = "apples";
        String seq = "abppplee";

        assertFalse(algo.solution(word, seq));
    }

    @ParameterizedTest
    @ValueSource(classes = {WordIsInSequenceNaive.class, WordIsInSequenceNaiveImproved.class})
    void emptyNOTInSequence(Class<WordIsInSequence> clazz) throws Exception {
        WordIsInSequence algo = clazz.getConstructor().newInstance();
        String word = "";
        String seq = "abppplee";

        assertFalse(algo.solution(word, seq));
    }

    @ParameterizedTest
    @ValueSource(classes = {WordIsInSequenceNaive.class, WordIsInSequenceNaiveImproved.class})
    void spaceNOTInSequence(Class<WordIsInSequence> clazz) throws Exception {
        WordIsInSequence algo = clazz.getConstructor().newInstance();
        String word = " ";
        String seq = "abppplee";

        assertFalse(algo.solution(word, seq));
    }

    @ParameterizedTest
    @ValueSource(classes = {WordIsInSequenceNaive.class, WordIsInSequenceNaiveImproved.class})
    void wordLongerThanSequence(Class<WordIsInSequence> clazz) throws Exception {
        WordIsInSequence algo = clazz.getConstructor().newInstance();
        String word = "abpppleee";
        String seq = "abppplee";

        assertFalse(algo.solution(word, seq));
    }

    @ParameterizedTest
    @ValueSource(classes = {WordIsInSequenceNaive.class, WordIsInSequenceNaiveImproved.class})
    void wordSameAsSequence(Class<WordIsInSequence> clazz) throws Exception {
        WordIsInSequence algo = clazz.getConstructor().newInstance();
        String word = "abppplee";
        String seq = "abppplee";

        assertTrue(algo.solution(word, seq));
    }

    @ParameterizedTest
    @ValueSource(classes = {WordIsInSequenceNaive.class, WordIsInSequenceNaiveImproved.class})
    void wordWithDifferentLetterOrderInSequence(Class<WordIsInSequence> clazz) throws Exception {
        WordIsInSequence algo = clazz.getConstructor().newInstance();
        String word = "bale";
        String seq = "pppablee";

        assertFalse(algo.solution(word, seq));
    }
}