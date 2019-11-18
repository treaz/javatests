package com.horiaconstantin.ctci.treesandgraphs;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepthsDFS implements ListOfDepths {

    public List<List<TreeNode>> solution(@NonNull TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();
        int level = 0;

        treeDSF(root, level, result);

        return result;
    }

    private void treeDSF(TreeNode node, int level, List<List<TreeNode>> result) {
        if (node == null) {
            return;
        }
        if (result.size() == level) {
            result.add(new LinkedList<>());
        }
        List<TreeNode> treeNodes = result.get(level);
        treeNodes.add(node);

        treeDSF(node.getLeft(), level + 1, result);
        treeDSF(node.getRight(), level + 1, result);
    }
}
