package com.horiaconstantin.ctci.treesandgraphs;


import lombok.NonNull;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

/**
 * Solution to problem 4.1
 */
public class RouteBetweenNodesWithJGraph implements RouteBetweenNodes {

    @Override
    public boolean solution(@NonNull BaseGraph g, @NonNull Node sourceNode, @NonNull Node destinationNode) {
        Graph<Integer, DefaultEdge> graph = generateGraph(g);
        return solveWithJGraph(graph, sourceNode, destinationNode);
    }

    private Graph<Integer, DefaultEdge> generateGraph(BaseGraph g) {
        Graph<Integer, DefaultEdge> directedGraph = new DefaultDirectedGraph<>(DefaultEdge.class);
        g.nodes.forEach(vertex -> directedGraph.addVertex(vertex.getValue()));
        g.nodes.forEach(vertex -> vertex.getChildren()
                .forEach(child -> directedGraph.addEdge(vertex.getValue(), child.getValue())));
        return directedGraph;
    }


    private boolean solveWithJGraph(Graph<Integer, DefaultEdge> directedGraph, Node sourceNode, Node destinationNode) {
        boolean isReachable = false;

        DijkstraShortestPath<Integer, DefaultEdge> shortestPath = new DijkstraShortestPath<>(directedGraph);
        if (shortestPath.getPath(sourceNode.getValue(), destinationNode.getValue()) != null) {
            isReachable = true;
        }
        return isReachable;
    }
}
