package com.edu.java.bst;

public class Node {

    int value;

    Node left;

    Node right;

    Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [" + value + "]";
    }
}
