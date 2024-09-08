package com.edu.java.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInOrderPreOrder {

	public static void main(String[] args) {
		int[] inOrder = { 40, 20, 50, 10, 60, 30 };
		int[] preOrder = { 10, 20, 40, 50, 30, 60 };
		Node root = constructTree(inOrder, preOrder);
		System.out.println(root);
	}

	private static Node constructTree(int[] inOrder, int[] preOrder) {
		Map<Integer, Integer> nodeIdxInfo = new HashMap<>();
		for (int idx = 0; idx < inOrder.length; idx++) {
			nodeIdxInfo.put(inOrder[idx], idx);
		}
		return prepareTree(inOrder, 0, inOrder.length - 1, preOrder, 0, preOrder.length - 1, nodeIdxInfo);
	}

	private static Node prepareTree(int[] in, int is, int ie, int[] pre, int ps, int pe,
			Map<Integer, Integer> inIdxInfo) {
		if (ps > pe || is > ie)
			return null;
		int curr = pre[ps];
		Node root = new Node(curr);
		int inRoot = inIdxInfo.get(curr);
		int numsToLeft = inRoot - is;
		root.left = prepareTree(in, is, inRoot - 1, pre, ps + 1, ps + numsToLeft, inIdxInfo);
		root.right = prepareTree(in, inRoot + 1, ie, pre, ps + numsToLeft + 1, pe, inIdxInfo);
		return root;
	}

}
