package com.edu.java.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		List<String> result = new ArrayList<>();
		preOrderTraversal(root, result);
		iterativePreOrder(root);
		System.out.println(result);
	}

	private static void preOrderTraversal(Node root, List<String> result) {
		if (null == root)
			return;

		result.add(String.valueOf(root.data));
		preOrderTraversal(root.left, result);
		preOrderTraversal(root.right, result);
	}

	private static void iterativePreOrder(Node root) {
		List<Integer> result = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		Node curr = root;
		while (true) {
			if (null != curr) {
				result.add(curr.data);
				stack.push(curr);
				curr = curr.left;
			} else {
				if (stack.isEmpty())
					break;
				curr = stack.pop().right;
			}
		}
		System.out.println(result);
	}
}
