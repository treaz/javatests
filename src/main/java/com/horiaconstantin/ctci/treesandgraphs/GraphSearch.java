package com.horiaconstantin.ctci.treesandgraphs;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class GraphSearch {


    public List<Node> depthFirstSearch(@NonNull BaseGraph g, @NonNull Node node) {
        List<Node> path = new ArrayList<>();
        boolean[] visited = new boolean[g.nodes.size()];
        return depthFirstSearch(visited, path, node);
    }

    /**
     * Performance O(n)
     */
    private List<Node> depthFirstSearch(boolean[] visited, List<Node> path, Node node) {
        visited[node.getValue()] = true;
        path.add(node);
        for (Node child : node.getChildren()) {
            if (!visited[child.getValue()]) {
                depthFirstSearch(visited, path, child);
            }
        }
        return path;
    }

    /**
     * Performance O(n)
     */
    public List<Node> breadthFirstSearch(@NonNull BaseGraph g, @NonNull Node node) {
        boolean[] visited = new boolean[g.nodes.size()];
        var path = new ArrayList<Node>();

        var queue = new ArrayDeque<Node>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            var queuedNode = queue.pollLast();
            if (visited[queuedNode.getValue()]) {
                continue;
            }
            visited[queuedNode.getValue()] = true;
            path.add(queuedNode);
            queuedNode.getChildren().forEach(queue::offer);
        }

        return path;
    }
}
