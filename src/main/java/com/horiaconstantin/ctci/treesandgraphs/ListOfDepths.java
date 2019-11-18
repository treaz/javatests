package com.horiaconstantin.ctci.treesandgraphs;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.*;

@UtilityClass
public class ListOfDepths {

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

        Collections.reverse(result);

        return result;
    }

}
