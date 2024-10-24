package com.edu.rest.api.test.bean;

public class TestProgram {

	public static void main(String[] args) {
		// For a binary tree, find the first common parent node of two given nodes in
		// the tree.
		// ex: Input: root = [6,2,8,0,4,7,9,null,null,3,5], n1 = 2, n2 = 8 Output: 6
		// Input: root = [6,2,8,0,4,7,9,null,null,3,5], n1 = 2, n2 = 4 Output: 2

		TreeNode root = new TreeNode(3);
		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(6);

		root.left = p;
		root.right = new TreeNode(1);
		// 6 2
		root.left.left = q;
		root.left.right = new TreeNode(2);
		// 0 8
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);

		// 7 4
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		TreeNode result = commonParent(root, p, q);
		System.out.println(result.val);

	}

	public static TreeNode commonParent(TreeNode root, TreeNode p, TreeNode q) {
		if (null == root || root == p || root == q) {
			return root;
		}
		TreeNode leftCommonParent = commonParent(root.left, p, q); // 5
		TreeNode rightCommonParent = commonParent(root.right, p, q); // null
		if (null == leftCommonParent) {
			return rightCommonParent;
		} else if (null == rightCommonParent) {
			return leftCommonParent;
		} else {
			return root;
		}
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

}
