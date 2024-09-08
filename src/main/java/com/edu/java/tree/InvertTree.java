package com.edu.java.tree;

public class InvertTree {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		Node invertRoot = invert(root);
		System.out.println(invertRoot);
	}

	private static Node invert(Node root) {
		if (null == root)
			return root;
		Node left = invert(root.left);
		Node right = invert(root.right);
		root.left = right;
		root.right = left;
		return root;
	}

}
