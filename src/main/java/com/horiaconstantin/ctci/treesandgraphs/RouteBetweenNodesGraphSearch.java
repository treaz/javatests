package com.horiaconstantin.ctci.treesandgraphs;

import lombok.NonNull;

import java.util.List;

public class RouteBetweenNodesGraphSearch implements RouteBetweenNodes {

    @Override
    public boolean solution(@NonNull BaseGraph g, @NonNull Node sourceNode, @NonNull Node destinationNode) {
        List<Node> nodes = GraphSearch.depthFirstSearch(g, sourceNode);
        return nodes.contains(destinationNode);
    }
}
