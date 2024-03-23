package com.edu.java.tree;

import java.util.Arrays;
import java.util.List;

public class ValidPathFromRooToLeaf {
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		List<Integer> requestPath = Arrays.asList(10, 8, 3);
		boolean isValidPath = validPathFromRootToLeaf(root, 0, requestPath);
		System.out.println(isValidPath);
	}

	private static boolean validPathFromRootToLeaf(Node root, int idx, List<Integer> inputPath) {

		if (null == root || idx >= inputPath.size() || root.data != inputPath.get(idx))
			return false;

		if (null == root.left && null == root.right && idx == inputPath.size() - 1)
			return true;

		boolean leftFlag = validPathFromRootToLeaf(root.left, idx + 1, inputPath);
		boolean rightFlag = validPathFromRootToLeaf(root.right, idx + 1, inputPath);

		return leftFlag || rightFlag;
	}
}
