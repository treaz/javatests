package com.horiaconstantin.ctci.treesandgraphs;

import lombok.NonNull;

public interface RouteBetweenNodes {

    boolean solution(@NonNull BaseGraph g, @NonNull Node sourceNode, @NonNull Node destinationNode);
}
