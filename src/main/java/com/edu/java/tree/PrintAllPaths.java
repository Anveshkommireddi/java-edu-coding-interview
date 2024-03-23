package com.edu.java.tree;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintAllPaths {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PrintAllPaths.class);

    Node root;


    public static void main(String args[]) {
        PrintAllPaths tree = new PrintAllPaths();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        /* Let us test the built tree by printing Inorder traversal */
        tree.printPaths(tree.root);
    }

    private List<List<String>> printPaths(Node root) {
        Node curr = root;
        List<List<String>> allPathsLst = new ArrayList<>();
        List<String> currPathLst = new ArrayList<>();
        printAllPaths(curr, currPathLst, allPathsLst);
        return allPathsLst;
    }

	private void printAllPaths(Node curr, List<String> currPath, List<List<String>> allPaths) {

		if (null == curr) return;

		currPath.add(String.valueOf(curr.data));

		if (null == curr.right && null == curr.left) {
			allPaths.add(currPath);
			LOGGER.info("{}", currPath);
		}

		printAllPaths(curr.left, currPath, allPaths);
		printAllPaths(curr.right, currPath, allPaths);
		currPath.remove(currPath.size() - 1);
	}
}
