package com.edu.java.tree;

public class BinaryTreeNode {

    int data;

    BinaryTreeNode left;

    BinaryTreeNode right;

    // below data members used only for some of the problems
    public BinaryTreeNode next;
    public BinaryTreeNode parent;
    public int count;

    public BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
        next = null;
        parent = null;
        count = 0;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +  "data=" + data +  '}';
    }

}
