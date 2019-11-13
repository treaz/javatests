package com.horiaconstantin.googletechdevguide.foundations;

import lombok.NonNull;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * https://techdevguide.withgoogle.com/paths/foundational/find-longest-word-in-dictionary-that-subsequence-of-given-string#!
 */
public class LongestWordInDict {

    public String solution(@NonNull List<String> dictionary, @NonNull String sequence) {
        WordIsInSequence algo = new WordIsInSequenceNaiveImproved();
        AtomicReference<String> solution = new AtomicReference<>("");
        dictionary.forEach(el -> {
            if (algo.solution(el, sequence) && el.length() > solution.get().length()) {
                solution.set(el);
            }
        });
        return solution.get();
    }

}
