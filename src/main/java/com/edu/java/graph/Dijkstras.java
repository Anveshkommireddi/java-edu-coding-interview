package com.edu.java.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class DijkstrasNode {

	int weight;

	int vertex;

	DijkstrasNode(int weight, int vertex) {
		this.weight = weight;
		this.vertex = vertex;
	}
}

public class Dijkstras {

	private static final Logger LOGGER = LoggerFactory.getLogger(Dijkstras.class);

	public static void main(String[] args) {
		int totalVertices = 5;
		WeightedGraph graph = createGraph(totalVertices);
		int srcVertex = 0;
		int[] dist = shortestPathFromSource(graph, totalVertices, srcVertex);
		LOGGER.info("Shotest Distance Array from source {} is {}", srcVertex, Arrays.toString(dist));
	}

	private static int[] shortestPathFromSource(WeightedGraph graph, int totalVertices, int srcVertex) {
		int[] dist = new int[totalVertices];
		for (int i = 0; i < totalVertices; i++)
			dist[i] = 100000000;
		dist[srcVertex] = 0;

		// create a minHeap based on the distance From the srcVertex
		PriorityQueue<DijkstrasNode> pq = new PriorityQueue<>((dij1, dij2) -> Integer.compare(dij1.weight, dij2.weight));
		pq.offer(new DijkstrasNode(0, srcVertex));

		while (!pq.isEmpty()) {
			DijkstrasNode dijNode = pq.poll();
			for (GraphNode graphNode : graph.adjLst.get(dijNode.vertex)) {
				if (graphNode.weight + dijNode.weight < dist[graphNode.toVertex]) {
					dist[graphNode.toVertex] = graphNode.weight + dijNode.weight;
					pq.offer(new DijkstrasNode(dist[graphNode.toVertex], graphNode.toVertex));
				}
			}
		}
		return dist;
	}

	private static WeightedGraph createGraph(int totalVertices) {
		WeightedGraph graph = new WeightedGraph(totalVertices);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 4);
		graph.addEdge(0, 3, 1);
		graph.addEdge(3, 2, 3);
		graph.addEdge(1, 4, 5);
		graph.addEdge(2, 4, 1);
		graph.printGraph();
		return graph;
	}

}
