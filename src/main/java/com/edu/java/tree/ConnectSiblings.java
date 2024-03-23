package com.edu.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectSiblings {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConnectSiblings.class);

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		connectSiblings(root);
		printNext(root);
	}

	private static void connectSiblings(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node prev = null;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node curr = queue.poll();
				if (null != prev) {
					prev.next = curr;
				}
				prev = curr;
				if (null != curr.left) {
					queue.add(curr.left);
				}
				if (null != curr.right) {
					queue.add(curr.right);
				}
			}
		}

	}
	
	private static void printNext(Node root) {
		List<Integer> nextList = new ArrayList<>();
		Node curr = root;
		while(null != curr) {
			nextList.add(curr.data);
			curr = curr.next;
		}
		
		LOGGER.info("Next List is {}", nextList);
	}

}
