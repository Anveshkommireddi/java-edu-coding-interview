package com.edu.java.graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetUnionBySize {

	public List<Integer> size;

	public List<Integer> parent;

	public DisjointSetUnionBySize(int verticies) {
		size = new ArrayList<>();
		parent = new ArrayList<>();
		for (int vertex = 0; vertex <= verticies; vertex++) {
			parent.add(vertex);
			size.add(1);
		}
	}

	public void unionBySize(int node1, int node2) {
		int node1UP = findUltimateParent(node1);
		int node2UP = findUltimateParent(node2);
		if (node1UP == node2UP)
			return;
		int node1UPSize = size.get(node1UP);
		int node2UPSize = size.get(node2UP);
		if (node1UPSize < node2UPSize) {
			parent.set(node1, node2UP);
			size.set(node2, node1UPSize + node2UPSize);
		} else {
			parent.set(node2, node1UP);
			size.set(node1, node1UPSize + node2UPSize);
		}
	}

	public int findUltimateParent(int node) {
		if (node == parent.get(node))
			return node;
		int ultimateParent = findUltimateParent(parent.get(node));
		parent.set(node, ultimateParent);
		return parent.get(node);
	}

}
