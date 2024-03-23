package com.edu.java.graph;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Graph {

	private static final Logger LOGGER = LoggerFactory.getLogger(Graph.class);

	List<List<Integer>> adjLst;
	int totalVertices;
	boolean isDirected;
	int connectedComponents;

	public Graph(int totalVertices) {
		this.adjLst = new ArrayList<>();
		for (int i = 0; i < totalVertices; i++)
			adjLst.add(new ArrayList<>());
		this.totalVertices = totalVertices;
		this.isDirected = false;
		this.connectedComponents = 0;
	}

	public Graph(int totalVertices, boolean isDirected) {
		this(totalVertices);
		this.isDirected = isDirected;
	}

	public void addEdge(int from, int to) {
		if (null == adjLst || adjLst.isEmpty())
			return;
		adjLst.get(from).add(to);
		if (Boolean.FALSE.booleanValue() == isDirected)
			adjLst.get(to).add(from);
	}

	public void printGraph() {

		if (null == adjLst || adjLst.isEmpty()) {
			LOGGER.info("Graph is Empty and Has No Edges to Print");
			return;
		}

		for (int i = 0; i < totalVertices; i++) {
			List<Integer> connections = adjLst.get(i);
			LOGGER.info("{} -----> {}", i, connections);
		}
	}

}
