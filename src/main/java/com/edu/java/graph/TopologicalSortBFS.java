package com.edu.java.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TopologicalSortBFS {

	private static final Logger LOGGER = LoggerFactory.getLogger(TopologicalSortBFS.class);

	public static void main(String[] args) {
		int vertices = 5;
		Graph graph = graphInput(vertices);
		List<Integer> result = topoSortUsingKhansAlgo(graph.adjLst, vertices);
		LOGGER.info("Result is {}", result);
	}

	private static List<Integer> topoSortUsingKhansAlgo(List<List<Integer>> adj, int V) {
		List<Integer> result = new ArrayList<>();
		int[] indegree = new int[V];
		//create in degree matrix
		for (List<Integer> connectedVertices : adj) {
			for (Integer connectedVertex : connectedVertices) {
				indegree[connectedVertex]++;
			}
		}

		// add 0 indegrees into queue
		Queue<Integer> queue = new LinkedList<>();
		for (int vertex = 0; vertex < indegree.length; vertex++) {
			if (indegree[vertex] == 0) {
				queue.add(vertex);
			}
		}
		
		//decrease indegrees for the remaining and add in result
		while (!queue.isEmpty()) {
			Integer currVertex = queue.poll();
			result.add(currVertex);
			for (Integer connectedVertex : adj.get(currVertex)) {
				indegree[connectedVertex]--;
				if (indegree[connectedVertex] == 0) {
					queue.add(connectedVertex);
				}
			}
		}
		return result;
	}

	private static Graph graphInput(int totalVertices) {
		Graph graph = new Graph(totalVertices, true);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(2, 4);
		graph.printGraph();
		return graph;
	}
}
