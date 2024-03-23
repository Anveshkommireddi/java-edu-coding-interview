package com.edu.java.bst;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InOrderBST {

	private static final Logger LOGGER = LoggerFactory.getLogger(InOrderBST.class);

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(5);
		bst.insert(15);
		bst.insert(12);
		bst.insert(18);
		List<Integer> inOrderList = new ArrayList<>();
		//bstInOrder(bst.root, inOrderList);
		LOGGER.info("InOrder List {}", inOrderList);
		List<Integer> revInOrderList = new ArrayList<>();
		bstRevInOrder(bst.root, revInOrderList);
		LOGGER.info("Reverse InOrder List {}", revInOrderList);
	}

	private static void bstRevInOrder(Node root, List<Integer> revInOrderList) {
		if (null == root) return;
		bstRevInOrder(root.right, revInOrderList);
		revInOrderList.add(root.value);
		bstRevInOrder(root.left, revInOrderList);
	}

	private static void bstInOrder(Node root, List<Integer> inOrderList) {
		if (null == root) return;
		bstInOrder(root.left, inOrderList);
		inOrderList.add(root.value);
		bstInOrder(root.right, inOrderList);
	}

}
