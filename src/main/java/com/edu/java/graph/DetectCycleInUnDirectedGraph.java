package com.edu.java.graph;

import java.util.List;
import java.util.Objects;

public class DetectCycleInUnDirectedGraph {

	public static void main(String[] args) {
		int discGraphVertices = 7;
		Graph discGraph = disconnectedGraph(discGraphVertices);
		boolean isCyclePresent = detectCycle(discGraph);
		System.out.println(isCyclePresent);
		System.out.println("=================");
		int conGraphVertices = 5;
		Graph conGraph = connectedGraph(conGraphVertices);
		isCyclePresent = detectCycle(conGraph);
		System.out.println(isCyclePresent);
	}

	private static boolean detectCycle(Graph graph) {
		List<List<Integer>> adjList = graph.adjLst;
		boolean[] visited = new boolean[adjList.size()];
		for (int srcIdx = 0; srcIdx < adjList.size(); srcIdx++) {
			Integer parent = 0;
			if (visited[srcIdx] == false) {
				boolean cyclePresent = cycleDetectionUsingDFS(adjList, visited, srcIdx, parent);
				if (cyclePresent)
					return true;
			}
		}
		return false;
	}

	private static boolean cycleDetectionUsingDFS(List<List<Integer>> adjList, boolean[] visited, int srcIdx,
			Integer parent) {

		visited[srcIdx] = true;
		List<Integer> connectedVertices = adjList.get(srcIdx);
		for (Integer connectedVertex : connectedVertices) {
			if (visited[connectedVertex] == false) {
				boolean result = cycleDetectionUsingDFS(adjList, visited, connectedVertex, srcIdx);
				if (result == true)
					return true;
			} else {
				return Objects.equals(parent, connectedVertex) ? false : true;
			}
		}

		return false;
	}

	private static Graph disconnectedGraph(int totalVertices) {
		Graph graph = new Graph(totalVertices);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(2, 3);
		graph.addEdge(1, 3);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(4, 6);
		graph.printGraph();
		return graph;
	}

	private static Graph connectedGraph(int totalVertices) {
		Graph graph = new Graph(totalVertices);
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
