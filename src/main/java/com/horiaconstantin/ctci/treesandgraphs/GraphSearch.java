package com.horiaconstantin.ctci.treesandgraphs;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class GraphSearch {


    public List<Node> depthFirstSearch(@NonNull Node node) {
        List<Node> path = new ArrayList<>();
        return depthFirstSearch(path, node);
    }

    private List<Node> depthFirstSearch(List<Node> path, Node node) {
        node.setVisited(true);
        path.add(node);
        for (Node child : node.getChildren()) {
            if (!child.getVisited()) {
                depthFirstSearch(path, child);
            }
        }
        return path;
    }

    public List<Node> breadthFirstSearch(@NonNull Node node) {
        var path = new ArrayList<Node>();

        var queue = new ArrayDeque<Node>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            var queuedNode = queue.pollLast();
            if (queuedNode.getVisited()) {
                continue;
            }
            queuedNode.setVisited(true);
            path.add(queuedNode);
            queuedNode.getChildren().forEach(queue::offer);
        }

        return path;
    }
}
