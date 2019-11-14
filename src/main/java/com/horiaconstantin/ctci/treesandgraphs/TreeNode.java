package com.horiaconstantin.ctci.treesandgraphs;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@RequiredArgsConstructor
@Accessors(chain = true)
public class TreeNode {

    private final int value;
    private TreeNode left;
    private TreeNode right;
}
