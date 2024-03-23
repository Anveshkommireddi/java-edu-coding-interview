package com.edu.java.bst;

import com.edu.java.tree.BinaryTreeNode;

public class FloorOfBST {
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(12);
        bst.insert(18);
        Node root = bst.root;
        Node floorNode = floorOfBSTRec(bst.root, 20);
        System.out.println(floorNode);
    }

    private static Node floorOfBST(Node root, int target) {
        Node floor = null;
        Node curr = root;
        while (null != curr) {
            if (curr.value == target) {
                return curr;
            } else if (target < curr.value) {
                curr = curr.left;
            } else {
                floor = curr;
                curr = curr.right;
            }
        }
        return floor;
    }

    private static Node floorOfBSTRec(Node root, int target) {
        if (null == root)
            return root;
        if (root.value == target) {
            return root;
        } else if (target < root.value) {
            return floorOfBSTRec(root.left, target);
        } else {
            Node floor = floorOfBSTRec(root.right, target);
            return null == floor ? root : floor;
        }
    }
}
