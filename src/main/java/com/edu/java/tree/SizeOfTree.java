package com.edu.java.tree;

public class SizeOfTree {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        int size = sizeOfTree(root);
        System.out.println(size);
    }

    private static int sizeOfTree(Node root) {
        if (null == root) return 0;
        int leftSize = sizeOfTree(root.left);
        int rightSize = sizeOfTree(root.right);
        return 1 + leftSize + rightSize;
    }
}
