package com.horiaconstantin.ctci.treesandgraphs;

import lombok.NonNull;

import java.util.Arrays;

/**
 * Solution to 4.2
 */
public class MinimalTree {

    public TreeNode solution(@NonNull int[] nodeValues) {
        if (nodeValues.length == 0) {
            throw new AlgoException();
        }
        return insertElement(nodeValues);
    }

    private TreeNode insertElement(int[] nodeValues) {
        if (nodeValues.length == 0) {
            return null;
        } else if (nodeValues.length == 1) {
            return new TreeNode(nodeValues[0]);
        }

        int midIndex = (nodeValues.length - 1) / 2;
        var leftArr = Arrays.copyOfRange(nodeValues, 0, midIndex);
        var rightArr = Arrays.copyOfRange(nodeValues, midIndex + 1, nodeValues.length);
        TreeNode node = new TreeNode(nodeValues[midIndex]);
        node.setLeft(insertElement(leftArr));
        node.setRight(insertElement(rightArr));

        return node;
    }
}

class AlgoException extends RuntimeException {
    private static final long serialVersionUID = -2647694756456288856L;
}