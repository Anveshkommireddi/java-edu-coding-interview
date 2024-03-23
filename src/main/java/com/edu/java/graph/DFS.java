package com.edu.java.graph;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DFS {

	private static final Logger LOGGER = LoggerFactory.getLogger(DFS.class);

	public static void main(String[] args) {
		int discGraphVertices = 7;
		Graph discGraph = disconnectedGraph(discGraphVertices);
		List<Integer> dfsDiscReslLst = dfs(discGraph);
		LOGGER.info("{}", dfsDiscReslLst);
		LOGGER.info("{}", "=================");
		int conGraphVertices = 5;
		Graph conGraph = connectedGraph(conGraphVertices);
		List<Integer> dfsConReslLst = dfs(conGraph);
		LOGGER.info("{}", dfsConReslLst);
	}

	private static List<Integer> dfs(Graph graph) {
		List<Integer> result = new ArrayList<>();
		List<List<Integer>> adjList = graph.adjLst;
		if (null == adjList || adjList.isEmpty())
			return result;
		boolean[] visited = new boolean[adjList.size()];
		for (int vertex = 0; vertex < adjList.size(); vertex++) {
			if (visited[vertex] == false) {
				dfsFromASource(vertex, adjList, visited, result);
			}
		}
		return result;
	}

	private static void dfsFromASource(int sourceVertex, List<List<Integer>> adjList, boolean[] visited,
			List<Integer> result) {
		visited[sourceVertex] = true;
		result.add(sourceVertex);
		List<Integer> connectedVertices = adjList.get(sourceVertex);
		for (Integer connectedVertex : connectedVertices) {
			if (visited[connectedVertex] == false) {
				dfsFromASource(connectedVertex, adjList, visited, result);
			}
		}
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
