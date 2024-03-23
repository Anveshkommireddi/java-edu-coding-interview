package com.edu.java.tree;

public class MaxMinOfTree {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        int max = maxOfTree(root);
        System.out.println(max);
        int min = minOfTree(root);
        System.out.println(min);
    }

    private static int minOfTree(Node root) {
        if (null == root)
            return Integer.MAX_VALUE;
        int leftMin = minOfTree(root.left);
        int rightMin = minOfTree(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    private static int maxOfTree(Node root) {
        if (null == root)
            return Integer.MIN_VALUE;
        int leftMax = maxOfTree(root.left);
        int rightMax = maxOfTree(root.right);
        return Math.max(root.data, Math.max(leftMax, rightMax));
    }
}
