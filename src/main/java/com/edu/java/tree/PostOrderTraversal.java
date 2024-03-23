package com.edu.java.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		List<String> result = new ArrayList<>();
		postOrderTraversal(root, result);
		iterativePostorderTraversal(root);
		System.out.println(result);
	}

	private static void postOrderTraversal(Node root, List<String> result) {
		if (null == root)
			return;

		postOrderTraversal(root.left, result);
		postOrderTraversal(root.right, result);
		result.add(String.valueOf(root.data));
	}

	public static List<Integer> iterativePreOrderTwoStacks(Node root) {
		List<Integer> result = new ArrayList<>();
		if (null == root)
			return result;
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		Node curr = root;
		stack1.add(curr);
		while (!stack1.isEmpty()) {
			Node currNode = stack1.pop();
			stack2.push(currNode);
			if (null != currNode.left)
				stack1.push(currNode.left);
			if (null != currNode.right)
				stack1.push(currNode.right);
		}

		while (!stack2.isEmpty()) {
			result.add(stack2.pop().data);
		}
		return result;
	}

	public static List<Integer> iterativePostorderTraversal(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		// previously printed node -- indicates that right tree is traversed
		Node pre = null;
		Node curr = root;
		Stack<Node> stack = new Stack<>();
		while (true) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				if (stack.isEmpty())
					break;
				curr = stack.peek();
				if (curr.right == null || curr.right == pre) {
					result.add(curr.data);
					stack.pop();
					pre = curr;
					curr = null;
				} else {
					curr = curr.right;
				}
			}
		}
		System.out.println(result);
		return result;
	}
}
