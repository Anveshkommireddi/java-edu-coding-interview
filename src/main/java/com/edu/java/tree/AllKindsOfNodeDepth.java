package com.edu.java.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllKindsOfNodeDepth {

	private static final Logger LOGGER = LoggerFactory.getLogger(AllKindsOfNodeDepth.class);

	Node root;

	public static void main(String[] args) {
		Node node = prepareTree();
		int nodeDepth = nodeDepth(node, 0);
		LOGGER.info("Node Depth from the Root is {}", nodeDepth);
		int allNodeDepths = allNodesDepth(node);
		LOGGER.info("Node Depth from the Root is {}", allNodeDepths);
	}

	private static int nodeDepth(Node root, Integer depth) {
		if (null == root) return 0;
		int leftDepth = nodeDepth(root.left, depth + 1);
		int rightDepth = nodeDepth(root.right, depth + 1);
		return depth + leftDepth + rightDepth;
	}

	private static int allNodesDepth(Node root) {
		Map<Node, NodeCountDepth> nodeCountDepthMap = new HashMap<>();
		nodeCount(root, nodeCountDepthMap);
		allNodesDepthHelper(root, nodeCountDepthMap);
		int sum  = 0;
		for(Map.Entry<Node, NodeCountDepth> entry : nodeCountDepthMap.entrySet()) {
			sum += entry.getValue().depth;
		}
		return sum;
	}

	private static int allNodesDepthHelper(Node root, Map<Node, NodeCountDepth> nodeCountDepthMap) {
		if(null == root) return 0;
		int leftNodesCount = allNodesDepthHelper(root.left, nodeCountDepthMap);
		int rightNodesCount = allNodesDepthHelper(root.right, nodeCountDepthMap);
		NodeCountDepth currNodeCountDepth = nodeCountDepthMap.getOrDefault(root, new NodeCountDepth(0, 0));
		currNodeCountDepth.depth = currNodeCountDepth.count + leftNodesCount + rightNodesCount;
		return  currNodeCountDepth.depth;
	}

	private static int nodeCount(Node root, Map<Node, NodeCountDepth> nodeCountDepthMap) {
		if(null == root) return 0;
		int leftCount = nodeCount(root.left, nodeCountDepthMap);
		int rightCount = nodeCount(root.right, nodeCountDepthMap);
		NodeCountDepth currNodeCountDepth = nodeCountDepthMap.getOrDefault(root, new NodeCountDepth(0, 0));
		currNodeCountDepth.count = leftCount + rightCount;
		nodeCountDepthMap.put(root, currNodeCountDepth);
		return  1 + leftCount + rightCount;
	}
	

	private static Node prepareTree() {
		AllKindsOfNodeDepth tree = new AllKindsOfNodeDepth();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);
		return tree.root;
	}

}

class NodeCountDepth {

	int count;
	int depth;

	public NodeCountDepth(int count, int depth) {
		this.count = count;
		this.depth = depth;
	}

	@Override
	public int hashCode() {
		return Objects.hash(count, depth);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NodeCountDepth other = (NodeCountDepth) obj;
		return count == other.count && depth == other.depth;
	}

	@Override
	public String toString() {
		return "NodeCountDepth [count=" + count + ", depth=" + depth + "]";
	}
	
}
