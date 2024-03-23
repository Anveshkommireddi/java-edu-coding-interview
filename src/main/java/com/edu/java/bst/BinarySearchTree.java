package com.edu.java.bst;

public class BinarySearchTree {

    Node root;

    public void insert(int val) {
        this.root = insert(this.root, val);
    }

    public boolean search(int val) {
        boolean isPresent = search(this.root, val);
        boolean isIterativePresent = searchIterative(this.root, val);
        return isPresent;
    }

    private boolean search(Node root, int val) {
        if (null == root)
            return false;
        if (root.value == val)
            return true;
        else if (val < root.value) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    private Node insert(Node root, int val) {
        if (null == root)
            return new Node(val);
        if (val < root.value) {
            root.left = insert(root.left, val);
        } else if (val > root.value) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    private boolean searchIterative(Node root, int val) {
        Node curr = root;
        while (null != curr) {
            if (val == curr.value)
                return true;
            else if (val < curr.value) {
                curr = curr.left;
            } else
                curr = curr.right;
        }
        return false;
    }

    private Node insertIterative(Node root, int val) {
        Node curr = root;
        Node parent = null;
        while (null != curr) {
            parent = curr;
            if (val < curr.value) {
                curr = curr.left;
            } else if (val > curr.value) {
                curr = curr.right;
            } else {
                return root;
            }
        }

        Node temp = new Node(val);
        if (null == parent)
            return temp;
        else if (val < parent.value)
            parent.left = temp;
        else
            parent.right = temp;
        return root;
    }
}
