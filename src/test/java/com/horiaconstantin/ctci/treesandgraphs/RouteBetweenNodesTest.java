package com.horiaconstantin.ctci.treesandgraphs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RouteBetweenNodesTest {

    @ParameterizedTest
    @ValueSource(classes = {RouteBetweenNodesWithJGraph.class, RouteBetweenNodesGraphSearch.class})
    void noFound(Class<RouteBetweenNodes> clazz) throws Exception {
        RouteBetweenNodes algo = clazz.getDeclaredConstructor().newInstance();
        TestGraph g = new TestGraph();
        BaseGraph base = new BaseGraph(Arrays.asList(g.zero, g.one, g.two, g.three, g.four, g.five));

        assertFalse(algo.solution(base, g.three, g.zero));
        assertFalse(algo.solution(base, g.two, g.zero));
        assertFalse(algo.solution(base, g.four, g.one));
    }

    @ParameterizedTest
    @ValueSource(classes = {RouteBetweenNodesWithJGraph.class, RouteBetweenNodesGraphSearch.class})
    void routeFound(Class<RouteBetweenNodes> clazz) throws Exception {
        RouteBetweenNodes algo = clazz.getDeclaredConstructor().newInstance();
        TestGraph g = new TestGraph();
        BaseGraph base = new BaseGraph(Arrays.asList(g.one, g.two, g.zero, g.three, g.four, g.five));

        assertTrue(algo.solution(base, g.zero, g.three));
        assertTrue(algo.solution(base, g.zero, g.two));
        assertTrue(algo.solution(base, g.one, g.four));
    }
}