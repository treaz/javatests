package com.horiaconstantin.ctci.treesandgraphs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RouteBetweenNodesTest {

    @ParameterizedTest
    @ValueSource(classes = {RouteBetweenNodesWithJGraph.class, RouteBetweenNodesGraphSearch.class})
    void noFound(Class<RouteBetweenNodes> clazz) throws Exception {
        RouteBetweenNodes algo = clazz.getDeclaredConstructor().newInstance();
        TestGraph g = new TestGraph();

        assertFalse(algo.solution(g.getBaseGraph(), g.three, g.zero));
        assertFalse(algo.solution(g.getBaseGraph(), g.two, g.zero));
        assertFalse(algo.solution(g.getBaseGraph(), g.four, g.one));
    }

    @ParameterizedTest
    @ValueSource(classes = {RouteBetweenNodesWithJGraph.class, RouteBetweenNodesGraphSearch.class})
    void routeFound(Class<RouteBetweenNodes> clazz) throws Exception {
        RouteBetweenNodes algo = clazz.getDeclaredConstructor().newInstance();
        TestGraph g = new TestGraph();

        assertTrue(algo.solution(g.getBaseGraph(), g.zero, g.three));
        assertTrue(algo.solution(g.getBaseGraph(), g.zero, g.two));
        assertTrue(algo.solution(g.getBaseGraph(), g.one, g.four));
    }
}