package com.edu.java.tree;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        int res = balancedBinaryTree(root);
        String result = res == -1 ? "UnBalanced" : "Balanced";
        System.out.println("Tree is " + result);
    }

    private static int balancedBinaryTree(Node root) {
        if (null == root)
            return 0;
        int lh = balancedBinaryTree(root.left);
        if (lh == -1)
            return -1;
        int rh = balancedBinaryTree(root.right);
        if (rh == -1)
            return -1;
        return Math.abs(lh - rh) > 1 ? -1 : 1 + Math.max(lh, rh);
    }
}
