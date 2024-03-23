package com.edu.java.bst;

public class InOrderSuccessor {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(100);
        bst.insert(50);
        bst.insert(200);
        bst.insert(25);
        bst.insert(75);
        bst.insert(125);
        bst.insert(350);
        Node root = bst.root;
        int successor = inOrderSuccesor(bst.root, 25);
        System.out.println(successor);
    }

    private static int inOrderSuccesor(Node root, int target) {
        Node succesor = null;
        Node curr = root;
        Node targetNode = null;
        while (null != curr) {
            if (curr.value > target) {
                succesor = curr;
                curr = curr.left;
            } else {
                if (target == curr.value) {
                    targetNode = curr;
                }
                curr = curr.right;
            }
        }
        return targetNode == null ? -1 : succesor.value;
    }
}
