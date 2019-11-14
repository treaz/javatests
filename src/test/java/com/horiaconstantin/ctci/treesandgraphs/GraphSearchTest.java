package com.horiaconstantin.ctci.treesandgraphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphSearchTest {

    private TestGraph g = new TestGraph();

    @BeforeEach
    void setup() {
        g = new TestGraph();
    }

    @Test
    void depthFirstSearch() {
        var actual = GraphSearch.depthFirstSearch(g.zero);

        assertEquals(Arrays.asList(g.zero, g.one, g.three, g.two, g.four, g.five), actual);
    }

    @Test
    void breadthFirstSearch() {
        var actual = GraphSearch.breadthFirstSearch(g.zero);

        assertEquals(Arrays.asList(g.zero, g.five, g.four, g.one, g.three, g.two), actual);
    }
}