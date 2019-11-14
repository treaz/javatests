package com.horiaconstantin.ctci.treesandgraphs;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class Node {
    private int value;
    private List<Node> children = new ArrayList<>();

    public Node(int value) {
        this.value = value;
    }

    public Node addChild(Node node) {
        children.add(node);
        return this;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
