package com.edu.java.tree;

import java.util.StringJoiner;

public class FlattenBinaryTreeToLinkedList {

	static Node prev = null;

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		flatten(root);
		String treeLL = print(root);
		System.out.println(treeLL);
	}

	private static void flatten(Node root) {

		if (null == root)
			return;

		flatten(root.right);
		flatten(root.left);

		root.right = prev;
		root.left = null;
		prev = root;

	}

	private static String print(Node root) {
		Node curr = root;
		StringJoiner sb = new StringJoiner("--->");
		while (null != curr) {
			sb.add(String.valueOf(curr.data));
			curr = curr.right;
		}
		return sb.toString();
	}

}
