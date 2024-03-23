package com.edu.java.tree;

import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaxWidthOfABinaryTree {

	private static final Logger LOGGER = LoggerFactory.getLogger(MaxWidthOfABinaryTree.class);

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.left = new Node(8);
		root.right.right = new Node(4);
		int maxWidth = maxWidth(root);
		LOGGER.info("Max Width of the Binary Tree is {}", maxWidth);
	}

	private static int maxWidth(Node root) {
		int result = 0;
		Queue<Tuple> queue = new LinkedList<>();
		queue.add(new Tuple(root, 0));
		while (!queue.isEmpty()) {
			int size = queue.size();
			int levelMin = queue.peek().vertical;
			int first = 0;
			int last = 0;
			for (int i = 0; i < size; i++) {
				Tuple currTuple = queue.poll();
				int currId = currTuple.vertical - levelMin;
				Node currNode = currTuple.node;
				if (i == 0) first = currId;
				if (i == size - 1) last = currId;
				if (null != currNode.left) {
					queue.add(new Tuple(currNode.left, 2 * currId + 1));
				}
				if (null != currNode.right) {
					queue.add(new Tuple(currNode.right, 2 * currId + 2));
				}
			}
			result = Math.max(result, last - first + 1);
		}
		return result;
	}

}
