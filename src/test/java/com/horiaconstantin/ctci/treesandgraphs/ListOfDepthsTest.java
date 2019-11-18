package com.horiaconstantin.ctci.treesandgraphs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ListOfDepthsTest {

    private TreeNode one = new TreeNode(1);
    private TreeNode two = new TreeNode(2);
    private TreeNode three = new TreeNode(3);
    private TreeNode four = new TreeNode(4);
    private TreeNode five = new TreeNode(5);
    private TreeNode six = new TreeNode(6);
    private TreeNode seven = new TreeNode(7);

    @ParameterizedTest
    @ValueSource(classes = {ListOfDepthsNaive.class, ListOfDepthsDFS.class})
    void fourNodes(Class<ListOfDepths> clazz) throws Exception {
        ListOfDepths algo = clazz.getDeclaredConstructor().newInstance();
        TreeNode input = two
                .setLeft(one)
                .setRight(three
                        .setRight(four));

        List<List<TreeNode>> actual = algo.solution(input);

        List<List<TreeNode>> expected = asList(singletonList(two), asList(one, three), singletonList(four));

        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @ValueSource(classes = {ListOfDepthsNaive.class, ListOfDepthsDFS.class})
    void sevenNodes(Class<ListOfDepths> clazz) throws Exception {
        ListOfDepths algo = clazz.getDeclaredConstructor().newInstance();
        TreeNode input = two
                .setLeft(one
                        .setLeft(five)
                        .setRight(six))
                .setRight(three
                        .setRight(four
                                .setRight(seven)));

        List<List<TreeNode>> actual = algo.solution(input);

        List<List<TreeNode>> expected = asList(singletonList(two), asList(one, three), asList(five, six, four), singletonList(seven));

        assertEquals(expected, actual);

    }
}