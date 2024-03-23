package com.edu.java.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoundaryTraversal {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BoundaryTraversal.class);

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.left.left.left = new Node(4);
		List<Integer> result = boundaryTraversal(root);
		LOGGER.info("Result is {}", result);
	}

	private static List<Integer> boundaryTraversal(Node root) {
		List<Integer> result = new ArrayList<>();
		if(null == root) return result;
		// collect left boundary using dfs
		leftBoundaryDFSExcludingLeaf(root, result);
		// collect leaf nodes
		collectLeafNodes(root, result);
		// collect right boundary using dfs
		Stack<Integer> rightBoundaryStack = new Stack<>();
		rightBoundaryDFSExcludingLeaf(root.right, rightBoundaryStack);
		result.addAll(rightBoundaryStack);
		return result;
	}

	private static void rightBoundaryDFSExcludingLeaf(Node root, Stack<Integer> result) {
		if(null == root) return;
		if(null == root.left && null == root.right) return;
		result.add(root.data);
		if(null != root.right) {
			rightBoundaryDFSExcludingLeaf(root.right, result);
		} else {
			rightBoundaryDFSExcludingLeaf(root.left, result);
		}
	}

	private static void collectLeafNodes(Node root, List<Integer> result) {
		if(null == root) return;
		if(null == root.left && null == root.right) {
			result.add(root.data);
			return;
		}
		collectLeafNodes(root.left, result);
		collectLeafNodes(root.right, result);
	}

	private static void leftBoundaryDFSExcludingLeaf(Node root, List<Integer> result) {
		if(null == root) return;
		if(null == root.left && null == root.right) return;
		result.add(root.data);
		if(null != root.left) {
			leftBoundaryDFSExcludingLeaf(root.left, result);
		} else {
			leftBoundaryDFSExcludingLeaf(root.right, result);
		}
	}

}
