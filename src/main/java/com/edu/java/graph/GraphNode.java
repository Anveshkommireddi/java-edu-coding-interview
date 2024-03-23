package com.edu.java.graph;

public class GraphNode {
	
	int fromVertex;

	int toVertex;

	int weight;

	public GraphNode(int fromVertex, int toVertex, int weight) {
		this.fromVertex = fromVertex;
		this.toVertex = toVertex;
		this.weight = weight;
	}
	
	public GraphNode(int toVertex, int weight) {
		this.toVertex = toVertex;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "GraphNode [fromVertex=" + fromVertex + ", toVertex=" + toVertex + ", weight=" + weight + "]";
	}

}
