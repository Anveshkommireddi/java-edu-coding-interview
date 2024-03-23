package com.edu.lc.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LC_133_CloneAGraph {

	private static final Logger LOGGER = LoggerFactory.getLogger(LC_133_CloneAGraph.class);

	public static void main(String[] args) {
		Node originalNode = new Node(1);
		Map<Node, Node> oldNewNodeRefMap = new HashMap<>();
		Node node = cloneGraph(originalNode, oldNewNodeRefMap);
		LOGGER.info("Node {}", node);
	}

	private static Node cloneGraph(Node node, Map<Node, Node> oldNewNodeRefMap) {
		Node newNode = new Node(node.val);
		oldNewNodeRefMap.put(node, newNode);
		List<Node> neighbours = node.neighbors;
		for (Node neighbour : neighbours) {
			if (!oldNewNodeRefMap.containsKey(neighbour)) {
				node.neighbors.add(cloneGraph(neighbour, oldNewNodeRefMap));
			} else {
				node.neighbors.add(oldNewNodeRefMap.get(neighbour));
			}
		}
		return oldNewNodeRefMap.get(node);
	}

}

class Node {

	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}