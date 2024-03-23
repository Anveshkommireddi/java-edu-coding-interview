package com.edu.java.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintNodesAtADistanceK {

	private static final Logger LOGGER = LoggerFactory.getLogger(PrintNodesAtADistanceK.class);

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		List<Node> leafNodesList = new ArrayList<>();
		getLeafNodes(root, leafNodesList);
		List<Integer> result = printNodesAtK(root, 2);
		LOGGER.info("Result is {}", result);
	}

	private static void getLeafNodes(Node root, List<Node> leafNodesList) {
		if (null == root)
			return;
		if (null == root.left && null == root.right) {
			leafNodesList.add(root);
			return;
		}
		getLeafNodes(root.left, leafNodesList);
		getLeafNodes(root.right, leafNodesList);
	}

	private static List<Integer> printNodesAtK(Node root, int k) {
		// prepare parent array
		Map<Node, Node> parentNodeMap = prepareParentMap(root);
		// traverse on parent and 2 childs using visited map
		List<Integer> result = bfs(parentNodeMap, root, k);
		return result;
	}

	private static List<Integer> bfs(Map<Node, Node> parentNodeMap, Node root, int k) {
		Map<Node, Boolean> nodeVisitedMap = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		nodeVisitedMap.put(root, true);
		int currSize = 0;
		while (!queue.isEmpty()) {
			if (currSize == k)
				break;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node currNode = queue.poll();
				// check parent
				Node parent = parentNodeMap.get(currNode);
				if (null != parent && nodeVisitedMap.getOrDefault(parent, false) == false) {
					nodeVisitedMap.put(parent, true);
					queue.add(parent);
				}
				// check left
				if (null != currNode.left && nodeVisitedMap.getOrDefault(currNode.left, false) == false) {
					nodeVisitedMap.put(currNode.left, true);
					queue.add(currNode.left);
				}
				// check right
				if (null != currNode.right && nodeVisitedMap.getOrDefault(currNode.right, false) == false) {
					nodeVisitedMap.put(currNode.right, true);
					queue.add(currNode.right);
				}
			}
			currSize++;
		}
		List<Integer> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			result.add(queue.poll().data);
		}
		return result;
	}

	private static Map<Node, Node> prepareParentMap(Node root) {
		Map<Node, Node> parentNodeMap = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node currNode = queue.poll();
				if (null != currNode.left) {
					parentNodeMap.put(currNode.left, currNode);
					queue.add(currNode.left);
				}
				if (null != currNode.right) {
					parentNodeMap.put(currNode.right, currNode);
					queue.add(currNode.right);
				}
			}
		}
		return parentNodeMap;
	}

}
