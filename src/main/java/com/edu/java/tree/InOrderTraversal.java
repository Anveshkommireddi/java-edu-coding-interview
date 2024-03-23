package com.edu.java.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		// List<String> result = new ArrayList<>();
		// inOrderTraversal(root, result);
		List<String> result = iterativeInOrderTraversal(root);
		System.out.println(result);
	}

	private static void inOrderTraversal(Node root, List<String> result) {
		if (null == root)
			return;

		inOrderTraversal(root.left, result);
		result.add(String.valueOf(root.data));
		inOrderTraversal(root.right, result);
	}

	private static List<String> iterativeInOrderTraversal(Node root) {
		List<String> result = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		Node curr = root;
		while (true) {
			if (null != curr) {
				stack.push(curr);
				curr = curr.left;
			} else {
				if (stack.isEmpty())
					break;
				Node temp = stack.pop();
				result.add(String.valueOf(temp.data));
				curr = temp.right;
			}
		}
		return result;
	}
}
