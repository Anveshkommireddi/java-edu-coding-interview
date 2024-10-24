package com.edu.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SerializeAndDeSerializeATree {

	private static final Logger LOGGER = LoggerFactory.getLogger(SerializeAndDeSerializeATree.class);

	public static void main(String[] args) {
//		Node root = new Node(20);
//		root.left = new Node(8);
//		root.right = new Node(22);
//		root.left.left = new Node(4);
//		root.left.right = new Node(12);
//		root.left.right.left = new Node(10);
//		root.left.right.right = new Node(14);
		
		Node root = new Node(1);
		root.right = new Node(2);
		root.right.right = new Node(3);
		root.right.right.right = new Node(4);
		root.right.right.right.right = new Node(5);
		printInOrder(root);
		String serializedTree = serialize(root);
		LOGGER.info("Serialized Tree is {}", serializedTree);
		Node newRoot = deSerialize(serializedTree);
		LOGGER.info("New Root is {}", newRoot);
		printInOrder(newRoot);
	}

	private static void printInOrder(Node root) {
		List<Integer> result = new ArrayList<>();
		inOrder(root, result);
		LOGGER.info("Result is {}", result);
	}

	private static void inOrder(Node root, List<Integer> result) {
		Stack<Node> stack = new Stack<>();
		Node curr = root;
		while (true) {
			if (null != curr) {
				stack.push(curr);
				curr = curr.left;
			} else {
				if (stack.isEmpty())
					break;
				Node currNode = stack.pop();
				result.add(currNode.data);
				curr = currNode.right;
			}
		}
	}

	private static Node deSerialize(String serializedTree) {
		String[] nodes = serializedTree.split(" ");
		Queue<Node> queue = new LinkedList<>();
		Node root = new Node(Integer.parseInt(nodes[0]));
		queue.add(root);
		for (int i = 1; i < nodes.length; i++) {
			Node currNode = queue.poll();
			if (!nodes[i].equals("#")) {
				currNode.left = new Node(Integer.parseInt(nodes[i]));
				queue.add(currNode.left);
			}

			if (!nodes[++i].equals("#")) {
				currNode.right = new Node(Integer.parseInt(nodes[i]));
				queue.add(currNode.right);
			}
		}
		return root;
	}

	private static String serialize(Node root) {
		StringBuilder sb = new StringBuilder();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node currNode = queue.poll();
				if (null == currNode) {
					sb.append("#").append(" ");
					continue;
				}
				sb.append(currNode.data).append(" ");
				queue.add(currNode.left);
				queue.add(currNode.right);
			}
		}
		return sb.toString();
	}

}
