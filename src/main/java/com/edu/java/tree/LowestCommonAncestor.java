package com.edu.java.tree;

public class LowestCommonAncestor {
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		Node lca = lca(root, root.left.left, root.left.right);
		System.out.println(lca);
	}

	private static Node lca(Node root, Node node1, Node node2) {
		if (null == root || node1 == root || node2 == root)
			return root;
		Node left = lca(root.left, node1, node2);
		Node right = lca(root.right, node1, node2);
		if (null == left)
			return right;
		else if (null == right)
			return left;
		else
			return root;
	}

}
