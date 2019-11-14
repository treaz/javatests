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
    private boolean visited;

    public Node(int value) {
        this.value = value;
    }

    public Node addChild(Node node) {
        children.add(node);
        return this;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean getVisited() {
        return visited;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", visited=" + visited +
                '}';
    }
}
