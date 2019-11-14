package com.horiaconstantin.ctci.treesandgraphs;

import lombok.NonNull;

import java.util.List;

public class RouteBetweenNodesGraphSearch implements RouteBetweenNodes {

    @Override
    public boolean solution(@NonNull BaseGraph g, @NonNull Node sourceNode, @NonNull Node destinationNode) {
        g.getNodes().forEach(e -> e.setVisited(false));
        List<Node> nodes = GraphSearch.depthFirstSearch(sourceNode);
        return nodes.contains(destinationNode);
    }
}
