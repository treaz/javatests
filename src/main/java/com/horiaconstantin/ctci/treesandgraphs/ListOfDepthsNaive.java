package com.horiaconstantin.ctci.treesandgraphs;

import lombok.NonNull;

import java.util.*;

public class ListOfDepthsNaive implements ListOfDepths {

    public List<List<TreeNode>> solution(@NonNull TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();

        ListIterator<List<TreeNode>> iter = result.listIterator();

        List<TreeNode> l1 = new LinkedList<>();
        l1.add(root);
        iter.add(l1);

        while (iter.hasPrevious()) {
            List<TreeNode> ll = iter.previous();
            List<TreeNode> level = new LinkedList<>();
            for (TreeNode node : ll) {
                if (node.getLeft() != null) {
                    level.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    level.add(node.getRight());
                }
            }
            if (!level.isEmpty()) {
                iter.add(level);
            }
        }

        // neet to rever the list because of using ListIterator with previous
        Collections.reverse(result);

        return result;
    }
}
