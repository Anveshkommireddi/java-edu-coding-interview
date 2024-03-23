package com.edu.java.graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TopologicalSortDFS {

	//Implemented only directed acyclic graph
	private static final Logger LOGGER = LoggerFactory.getLogger(TopologicalSortDFS.class);
	
	public static void main(String[] args) {
		int totalVertices = 5;
		Graph graph = directedGraph2(totalVertices);
		Stack<Integer> result = topologicalSortDFS(graph.adjLst);
		int[] topo = new int[totalVertices];
		int i = 0;
		while(!result.isEmpty()) {
			topo[i++] = result.peek();
			result.pop();
		}
		LOGGER.info("Result :: {}", Arrays.toString(topo));
	}
	
	private static Stack<Integer> topologicalSortDFS(List<List<Integer>> adjLst) {
		int vertices = adjLst.size();
		boolean[] visited = new boolean[vertices];
		Stack<Integer> result = new Stack<>();
		for (int vertex = 0; vertex < vertices; vertex++) {
			if(visited[vertex] == false) {
				dfs(adjLst, visited, vertex, result);
			}
		}
		return result;
	}

	private static void dfs(List<List<Integer>> adjLst, boolean[] visited, int srcVertex, Stack<Integer> result) {
		visited[srcVertex] = true;
		List<Integer> connectedVertices = adjLst.get(srcVertex);
		for (Integer connectedVertex : connectedVertices) {
			if (visited[connectedVertex] == false) {
				dfs(adjLst, visited, connectedVertex, result);
			}
		}
		result.push(srcVertex);
	}

	private static Graph directedGraph(int totalVertices) {
		Graph graph = new Graph(totalVertices, true);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(5, 0);
		graph.addEdge(5, 2);
		graph.printGraph();
		return graph;
	}
	
	private static Graph directedGraph2(int totalVertices) {
		Graph graph = new Graph(totalVertices, true);
		graph.addEdge(3, 0);
		graph.addEdge(3, 4);
		graph.addEdge(3, 2);
		graph.addEdge(0, 2);
		graph.printGraph();
		return graph;
	}
	
}
