package com.edu.java.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TopViewOfBinaryTree {

	private static final Logger LOGGER = LoggerFactory.getLogger(TopViewOfBinaryTree.class);

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(10);
		root.right.left = new Node(9);
		root.right.right = new Node(11);
		root.left.left.right = new Node(5);
		root.left.left.right.right = new Node(6);
		Map<Integer, Integer> topViewMap = topViewOfBinaryTree(root);
		// iterate and print for solution
		LOGGER.info("Top View is {}", topViewMap);

	}

	private static Map<Integer, Integer> topViewOfBinaryTree(Node root) {
		Map<Integer, Integer> result = new TreeMap<>();
		Queue<Tuple> queue = new LinkedList<>();
		queue.add(new Tuple(root, 0));
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Tuple currTuple = queue.poll();
				Node currNode = currTuple.node;
				int currVertical = currTuple.vertical;
				if (!result.containsKey(currVertical)) {
					result.put(currVertical, currNode.data);
				}

				if (null != currNode.left) {
					queue.add(new Tuple(currNode.left, currVertical - 1));
				}

				if (null != currNode.right) {
					queue.add(new Tuple(currNode.left, currVertical + 1));
				}
			}
		}
		return result;
	}
}
