package com.edu.java.tree;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeftViewOfABinaryTree {

	private static final Logger LOGGER = LoggerFactory.getLogger(LeftViewOfABinaryTree.class);

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
		Map<Integer, Integer> levelVerticalMap = new HashMap<>();
		leftViewOfTree(root, 0, levelVerticalMap);
		LOGGER.info("Left View is {}", levelVerticalMap);
	}

	private static void leftViewOfTree(Node root, int vertical, Map<Integer, Integer> levelVerticalMap) {
		if (null == root) return;
		if (levelVerticalMap.size() == vertical) {
			levelVerticalMap.put(vertical, root.data);
		}
		leftViewOfTree(root.left, vertical + 1, levelVerticalMap);
		leftViewOfTree(root.right, vertical + 1, levelVerticalMap);
	}

}
