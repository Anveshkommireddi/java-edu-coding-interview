package com.edu.java.bst;

public class CeilOfBST {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(12);
        bst.insert(18);
        Node root = bst.root;
        Node ceilNode = ceilOfBST(bst.root, 14);
        System.out.println(ceilNode);
    }

    private static Node ceilOfBST(Node root, int target) {
       Node ceil = null;
       Node curr = root;
       while(null != curr) {
           if(target == curr.value) {
               return curr;
           } else if(target < curr.value) {
               ceil = curr;
               curr = curr.left;
           } else {
               curr = curr.right;
           }
       }
       return ceil;
    }

    private static Node ceilOfBSTRec(Node root, int target) {
        if(null == root)
            return root;

        if(target == root.value) {
            return root;
        } else if (target < root.value) {
            Node ceil = ceilOfBSTRec(root.left, target);
            return null != ceil ? ceil : root;
        } else {
            return ceilOfBSTRec(root.right, target);
        }
    }
}
