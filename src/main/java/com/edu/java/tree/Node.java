package com.edu.java.tree;

import java.util.Objects;

public class Node {
	int data;
	Node left;
	Node right;
	Node next;

	Node(int item) {
		data = item;
		left = right = null;
	}

	@Override
	public String toString() {
		return "Node{" + "data=" + data + '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(data);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		return data == other.data;
	}
}
