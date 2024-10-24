package com.edu.java.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedundantConnection {

	public static void main(String[] args) {
		int[][] edges = { { 1, 2 }, { 1, 3 }, { 3, 4 }, { 2, 4 } };
		// int[][] edges = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 3, 4 }, { 4, 5 } };
		int[] result = findRedundantConnection(edges);
		System.out.println(Arrays.toString(result));
	}

	private static int[] findRedundantConnection(int[][] edges) {
		int n = edges.length;
		DSUF dsuf = new DSUF(n);
		for (int[] edge : edges) {
			int from = edge[0];
			int to = edge[1];
			boolean isConnected = dsuf.union(from, to);
			if (isConnected == true) {
				System.out.println("From is ::: " + from + " To is ::: " + to);
			}
		}
		return null;
	}

}

class DSUF {

	List<Integer> size;

	List<Integer> parent;

	public DSUF(int n) {
		size = new ArrayList<>();
		parent = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			size.add(1);
			parent.add(i);
		}
	}

	public boolean union(int v1, int v2) {
		int upv1 = fup(v1);
		int upv2 = fup(v2);
		if (upv1 == upv2)
			return true;
		if (size.get(upv1) >= size.get(upv2)) {
			size.set(upv1, size.get(upv2) + size.get(upv1));
			parent.set(upv2, upv1);
		} else {
			size.set(upv2, size.get(upv2) + size.get(upv1));
			parent.set(upv1, upv2);
		}
		return false;
	}

	public int fup(int node) {
		if (parent.get(node) == node) {
			return node;
		}
		int up = fup(parent.get(node));
		parent.set(node, up);
		return parent.get(node);
	}
}
