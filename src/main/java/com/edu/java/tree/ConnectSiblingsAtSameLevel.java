package com.edu.java.tree;

import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectSiblingsAtSameLevel {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConnectSiblings.class);

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		connectSiblingsAtSameLevel(root);
	}

	private static void connectSiblingsAtSameLevel(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node prev = null;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node curr = queue.poll();
				
				if(null != prev) {
					prev.next = curr;
				}
				prev = curr;
				if (null != curr.left) {
					queue.add(curr.left);
				}

				if (null != curr.right) {
					queue.add(curr.right);
				}

				if (i == size - 1) {
					prev = null;
				}
			}
		}
	}

}
