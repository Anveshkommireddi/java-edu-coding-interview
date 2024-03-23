package com.edu.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerticalOrderTraversal {

	private static final Logger LOGGER = LoggerFactory.getLogger(VerticalOrderTraversal.class);

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
		Map<Integer, Map<Integer, List<Integer>>> verticalLevelNodesMap = verticalOrderTraversal(root);
		LOGGER.info("Result is {}", verticalLevelNodesMap);
		Map<Integer, List<Integer>> voNodesMap = voTraversal(root);
		List<Integer> votraversalList =  voNodesMap.entrySet().stream().flatMap(entry -> entry.getValue().stream()).collect(Collectors.toList());
		LOGGER.info("VO TRAVERSAL {}", votraversalList);

	}

	private static Map<Integer, Map<Integer, List<Integer>>> verticalOrderTraversal(Node root) {
		Map<Integer, Map<Integer, List<Integer>>> verticalLevelNodesListMap = new TreeMap<>();
		Queue<Tuple> queue = new LinkedList<>();
		queue.add(new Tuple(root, 0, 0));
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Tuple currNode = queue.poll();
				int currVertical = currNode.vertical;
				int currLevel = currNode.level;
				Map<Integer, List<Integer>> levelNodesLstMap = verticalLevelNodesListMap.getOrDefault(currVertical,
						new TreeMap<>());
				List<Integer> nodesLst = levelNodesLstMap.getOrDefault(currLevel, new ArrayList<>());
				nodesLst.add(root.data);
				levelNodesLstMap.put(currLevel, nodesLst);
				verticalLevelNodesListMap.put(currVertical, levelNodesLstMap);

				if (null != currNode.node.left) {
					queue.add(new Tuple(currNode.node.left, currVertical - 1, currLevel + 1));
				}

				if (null != currNode.node.right) {
					queue.add(new Tuple(currNode.node.right, currVertical + 1, currLevel + 1));
				}

			}
		}
		return verticalLevelNodesListMap;
	}

	private static Map<Integer, List<Integer>> voTraversal(Node root) {
		
		Map<Integer, List<Integer>> voNodesMap = new TreeMap<>();
		Queue<Tuple> queue = new LinkedList<>();
		queue.add(new Tuple(root, 0));
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				
				Tuple currTuple = queue.poll();
				int currVertical = currTuple.vertical;
				Node currNode = currTuple.node;
				
				List<Integer> currList = voNodesMap.getOrDefault(currVertical, new ArrayList<>());
				currList.add(currNode.data);
				voNodesMap.put(currVertical, currList);
				
				if(null != currNode.left) {
					queue.add(new Tuple(currNode.left, currVertical - 1));
				} 
				
				if(null != currNode.right) {
					queue.add(new Tuple(currNode.right, currVertical + 1));
				}
			}
		}
		return voNodesMap;
	}

}
