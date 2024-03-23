package com.edu.java.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TopologicalSortCycleDetection {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TopologicalSortCycleDetection.class);
	
	public static void main(String[] args) {
		int vertices = 5;
		Graph graph = graphInput(vertices);
		boolean hasCycle = topoSort(graph.adjLst, vertices);
		LOGGER.info("Is Cycle Present :: {}", hasCycle);
	}
	
	private static boolean topoSort(List<List<Integer>> adjLst, int V) {
		int[] indegree = new int[V];
		for (int vertex = 0; vertex < V; vertex++) {
			List<Integer> connectedVertices = adjLst.get(vertex);
			for (Integer connectedVertex : connectedVertices) {
				indegree[connectedVertex]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0)
				queue.add(i);
		}
		
		List<Integer> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			Integer currVertex = queue.poll();
			result.add(currVertex);
			List<Integer> connectedVertices = adjLst.get(currVertex);
			for (Integer connectedVertex : connectedVertices) {
				indegree[connectedVertex]--;
				if (indegree[connectedVertex] == 0) {
					queue.add(connectedVertex);
				}
			}
		}
		
		return result.size() != V;
	}

	private static Graph graphInput(int totalVertices) {
		Graph graph = new Graph(totalVertices, true);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 1);
		graph.printGraph();
		return graph;
	}

}
