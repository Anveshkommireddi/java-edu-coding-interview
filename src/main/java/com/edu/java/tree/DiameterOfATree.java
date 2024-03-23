package com.edu.java.tree;

public class DiameterOfATree {

    private static int diameter;

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        diameterOfTree(root);
        System.out.println("Diameter of the tree is " + diameter);
    }

    private static int diameterOfTree(Node root) {
        if (null == root)
            return 0;

        int lh = diameterOfTree(root.left);
        int rh = diameterOfTree(root.right);
        diameter = Math.max(diameter, 1 + lh + rh);
        return 1 + Math.max(lh, rh);
    }
}
