package com.horiaconstantin.ctci.treesandgraphs;

class TestGraph {

    Node zero = new Node(0);
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);

    TestGraph() {
        zero.addChild(one)
                .addChild(four)
                .addChild(five);

        one.addChild(three)
                .addChild(four);

        two.addChild(one);

        three.addChild(two);
    }
}
