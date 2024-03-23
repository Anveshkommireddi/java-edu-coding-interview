package com.edu.java.graph;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeightedGraph {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeightedGraph.class);

	List<List<GraphNode>> adjLst;
	int totalVertices;
	boolean isDirected;
	int connectedComponents;

	public WeightedGraph(int totalVertices) {
		this.totalVertices = totalVertices;
		this.connectedComponents = 0;
		this.isDirected = false;
		adjLst = new ArrayList<>();
		for (int i = 0; i < totalVertices; i++)
			adjLst.add(new ArrayList<>());
	}

	public WeightedGraph(int totalVertices, boolean isDirected) {
		this(totalVertices);
		this.isDirected = isDirected;
	}

	public void addEdge(int from, int to, int weight) {
		if (null == adjLst || adjLst.isEmpty())
			return;
		GraphNode srcToDestNode = new GraphNode(from, to, weight);
		adjLst.get(from).add(srcToDestNode);
		if (Boolean.FALSE.booleanValue() == isDirected) {
			GraphNode destToSrcNode = new GraphNode(to, from, weight);
			adjLst.get(to).add(destToSrcNode);
		}
	}

	public void printGraph() {

		if (null == adjLst || adjLst.isEmpty()) {
			LOGGER.info("Graph is Empty and Has No Edges to Print");
			return;
		}

		for (int i = 0; i < totalVertices; i++) {
			List<GraphNode> connections = adjLst.get(i);
			LOGGER.info("{} -----> {}", i, connections);
		}
	}
}
