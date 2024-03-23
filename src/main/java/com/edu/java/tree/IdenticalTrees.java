package com.edu.java.tree;

import java.util.List;
import java.util.ArrayList;

public class IdenticalTrees {

    public static void main(String[] argv) {
        // Creating first binary tree with tree as tree1
        List<Integer> input1 = new ArrayList<Integer>();
        input1.add(100);
        input1.add(50);
        input1.add(200);
        input1.add(25);
        input1.add(125);
        input1.add(350);
        BinaryTree tree1 = new BinaryTree(input1);

        // Creating second binary tree with different values and structure,
        List<Integer> input2 = new ArrayList<Integer>();
        input2.add(4);
        input2.add(2);
        input2.add(6);
        input2.add(1);
        input2.add(5);
        input2.add(7);
        BinaryTree tree2 = new BinaryTree(input2);

        // Creating third binary tree with different structure and same values as
        // tree1
        List<Integer> input3 = new ArrayList<Integer>();
        input3.add(100);
        input3.add(25);
        input3.add(200);
        input3.add(50);
        input3.add(125);
        input3.add(350);
        BinaryTree tree1DiffLayout = new BinaryTree(input3);

        // Defining Test Cases
        BinaryTreeNode[] testCaseRoot1 = {tree1.root, tree1.root, tree1.root, tree1.root, null};
        BinaryTreeNode[] testCaseRoot2 = {tree1.root, tree2.root, tree1DiffLayout.root, null, null};

        for (int i = 0; i < testCaseRoot1.length; i++) {
            if (i > 0) {
                System.out.print("\n");
            }

            // Calling our areIdentical() function to check if tree are identical
            if (areIdentical(testCaseRoot1[i], testCaseRoot2[i])) {
                System.out.print("true");
            } else {
                System.out.print("false");
            }
            System.out.print(
                    "\n----------------------------------------------------------------------------------------------------\n");
        }
    }

    private static boolean areIdentical(BinaryTreeNode binaryTreeNode1, BinaryTreeNode binaryTreeNode2) {
        BinaryTreeNode currNode1 = binaryTreeNode1;
        BinaryTreeNode currNode2 = binaryTreeNode2;
        return validate(currNode1, currNode2);
    }

    private static boolean validate(BinaryTreeNode currNode1, BinaryTreeNode currNode2) {

        if (null == currNode1 && null == currNode2) {
            return true;
        }

        if (null != currNode1 && null != currNode2) {
            return validate(currNode1.left, currNode2.left)
                    && currNode1.data == currNode2.data
                    && validate(currNode1.right, currNode2.right);
        }
        return false;
    }
}
