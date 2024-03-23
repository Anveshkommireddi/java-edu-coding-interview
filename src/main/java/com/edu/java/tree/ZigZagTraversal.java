package com.edu.java.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZigZagTraversal {

	private static final Logger LOGGER = LoggerFactory.getLogger(ZigZagTraversal.class);

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		ArrayList<Integer> result = zigZagTraversal(root);
		LOGGER.info("Result is {}", result);
	}

	private static ArrayList<Integer> zigZagTraversal(Node root) {
		ArrayList<Integer> result = new ArrayList<>();
		Deque<Node> queue = new ArrayDeque<>();
		queue.addFirst(root);
		boolean leftToRight = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node currNode = leftToRight ? queue.pollFirst() : queue.pollLast();
				result.add(currNode.data);
				if (leftToRight) {
					if (null != currNode.left) {
						queue.offerLast(currNode.left);
					}
					if (null != currNode.right) {
						queue.offerLast(currNode.right);
					}
				} else {
					if (null != currNode.right) {
						queue.offerFirst(currNode.right);
					}
					if (null != currNode.left) {
						queue.offerFirst(currNode.left);
					}
				}
			}
			leftToRight = !leftToRight;
		}
		return result;
	}

}
