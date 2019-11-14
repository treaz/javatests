package com.horiaconstantin.ctci.treesandgraphs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MinimalTreeTest {

    @ParameterizedTest
    @ValueSource(classes = MinimalTree.class)
    void oneValueArray(Class<MinimalTree> clazz) throws Exception {
        MinimalTree algo = clazz.getDeclaredConstructor().newInstance();

        TreeNode actual = algo.solution(new int[]{1});

        assertEquals(new TreeNode(1), actual);
    }

    @ParameterizedTest
    @ValueSource(classes = MinimalTree.class)
    void emptyArray(Class<MinimalTree> clazz) throws Exception {
        MinimalTree algo = clazz.getDeclaredConstructor().newInstance();

        assertThrows(AlgoException.class, () -> algo.solution(new int[]{}));
    }

    @ParameterizedTest
    @ValueSource(classes = MinimalTree.class)
    void twoValueArray(Class<MinimalTree> clazz) throws Exception {
        MinimalTree algo = clazz.getDeclaredConstructor().newInstance();

        TreeNode actual = algo.solution(new int[]{1, 2});

        TreeNode expected = new TreeNode(1)
                .setRight(new TreeNode(2));

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(classes = MinimalTree.class)
    void threeValueArray(Class<MinimalTree> clazz) throws Exception {
        MinimalTree algo = clazz.getDeclaredConstructor().newInstance();

        TreeNode actual = algo.solution(new int[]{1, 2, 3});

        TreeNode expected = new TreeNode(2)
                .setLeft(new TreeNode(1))
                .setRight(new TreeNode(3));

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(classes = MinimalTree.class)
    void fourValueArray(Class<MinimalTree> clazz) throws Exception {
        MinimalTree algo = clazz.getDeclaredConstructor().newInstance();

        TreeNode actual = algo.solution(new int[]{1, 2, 3, 4});

        TreeNode expected = new TreeNode(2)
                .setLeft(new TreeNode(1))
                .setRight(new TreeNode(3)
                        .setRight(new TreeNode(4)));

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(classes = MinimalTree.class)
    void fiveValueArray(Class<MinimalTree> clazz) throws Exception {
        MinimalTree algo = clazz.getDeclaredConstructor().newInstance();

        TreeNode actual = algo.solution(new int[]{1, 2, 3, 4, 5});

        TreeNode expected = new TreeNode(3)
                .setLeft(new TreeNode(1)
                        .setRight(new TreeNode(2)))
                .setRight(new TreeNode(4)
                        .setRight(new TreeNode(5)));

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(classes = MinimalTree.class)
    void sixValueArray(Class<MinimalTree> clazz) throws Exception {
        MinimalTree algo = clazz.getDeclaredConstructor().newInstance();

        TreeNode actual = algo.solution(new int[]{1, 2, 3, 4, 5, 6});

        TreeNode expected = new TreeNode(3)
                .setLeft(new TreeNode(1)
                        .setRight(new TreeNode(2)))
                .setRight(new TreeNode(5)
                        .setLeft(new TreeNode(4))
                        .setRight(new TreeNode(6)));

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(classes = MinimalTree.class)
    void sevenValueArray(Class<MinimalTree> clazz) throws Exception {
        MinimalTree algo = clazz.getDeclaredConstructor().newInstance();

        TreeNode actual = algo.solution(new int[]{1, 2, 3, 4, 5, 6, 7});

        TreeNode expected = new TreeNode(4)
                .setLeft(new TreeNode(2)
                        .setLeft(new TreeNode(1))
                        .setRight(new TreeNode(3)))
                .setRight(new TreeNode(6)
                        .setLeft(new TreeNode(5))
                        .setRight(new TreeNode(7)));

        assertEquals(expected, actual);
    }

}