package com.horiaconstantin.ctci.treesandgraphs;

import lombok.Getter;

import java.util.Arrays;

class TestGraph {

    Node zero = new Node(0);
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);

    @Getter
    private BaseGraph baseGraph;

    TestGraph() {
        zero.addChild(one)
                .addChild(four)
                .addChild(five);

        one.addChild(three)
                .addChild(four);

        two.addChild(one);

        three.addChild(two);

        baseGraph = new BaseGraph(Arrays.asList(zero, one, two, three, four, five));
    }
}
