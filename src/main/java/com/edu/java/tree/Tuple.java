package com.edu.java.tree;

public class Tuple {

	int vertical;

	int level;

	Node node;

	public Tuple(Node node, int vertical) {
		this.node = node;
		this.vertical = vertical;
	}

	public Tuple(Node node, int vertical, int level) {
		this(node, vertical);
		this.level = level;
	}

	@Override
	public String toString() {
		return "Tuple [vertical=" + vertical + ", level=" + level + ", node=" + node + "]";
	}

}
