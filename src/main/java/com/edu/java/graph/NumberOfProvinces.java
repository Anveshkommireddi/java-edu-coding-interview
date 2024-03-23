package com.edu.java.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberOfProvinces {

	private static final Logger LOGGER = LoggerFactory.getLogger(NumberOfProvinces.class);

	public static void main(String[] args) {
		int[][] graph = { { 1, 0, 0, 1 }, 
						  { 0, 1, 1, 0 }, 
						  { 0, 1, 1, 1 }, 
						  { 1, 0, 1, 1 } };
		int dsConnectedComponents = dsu(graph);
		int connectedComponents = getNumberOfProvinces(graph);
		LOGGER.info("Number Of Connected Components is {}", connectedComponents);
		List<List<Integer>> adjLst = getAdjacencyList(graph);
		connectedComponents = getNumberOfProvinces(adjLst);
		LOGGER.info("Number Of Connected Components from adjacency List is {}", connectedComponents);
	}

	private static int getNumberOfProvinces(List<List<Integer>> adjLst) {
		int connectedComponents = 0;
		boolean[] visited = new boolean[adjLst.size()];
		for (int vertex = 0; vertex < adjLst.size(); vertex++) {
			if (visited[vertex] == false) {
				bfs(adjLst, vertex, visited);
				connectedComponents++;
			}
		}
		return connectedComponents;
	}

	private static void bfs(List<List<Integer>> adjLst, int source, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		visited[source] = true;

		while (!queue.isEmpty()) {
			int src = queue.poll();
			List<Integer> connectedVertices = adjLst.get(src);
			for (int connectedVertex : connectedVertices) {
				if (visited[connectedVertex] == false) {
					visited[connectedVertex] = true;
					queue.add(connectedVertex);
				}
			}
		}

	}

	private static List<List<Integer>> getAdjacencyList(int[][] graph) {
		List<List<Integer>> adjLst = new ArrayList<>();
		for (int i = 0; i < graph.length; i++)
			adjLst.add(new ArrayList<>());
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				if (i != j && graph[i][j] == 1) {
					adjLst.get(i).add(j);
				}
			}
		}
		return adjLst;
	}

	private static int getNumberOfProvinces(int[][] graph) {
		int connectedComponents = 0;
		int totalVertices = graph.length;
		boolean[] visited = new boolean[totalVertices];
		for (int vertex = 0; vertex < totalVertices; vertex++) {
			if (visited[vertex] == false) {
				bfs(graph, visited, vertex);
				connectedComponents++;
			}
		}
		return connectedComponents;
	}

	private static void bfs(int[][] graph, boolean[] visited, int vertex) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(vertex);
		visited[vertex] = true;

		while (!queue.isEmpty()) {
			int source = queue.poll();
			for (int v = 0; v < graph.length; v++) {
				if (graph[source][v] == 1 && visited[v] == false) {
					visited[v] = true;
					queue.add(v);
				}
			}
		}
	}
	
	private static int dsu(int[][] graph) {
		int n = graph.length;
		DisjointSetUnionBySize dsu = new DisjointSetUnionBySize(n-1);
		for (int rowIdx = 0; rowIdx < graph.length; rowIdx++) {
			for (int colIdx = 0; colIdx < graph[rowIdx].length; colIdx++) {
				if (rowIdx != colIdx && graph[rowIdx][colIdx] == 1) {
					dsu.unionBySize(rowIdx, colIdx);
				}
			}
		}
		List<Integer> parent = dsu.parent;
		return 0;
	}

}
