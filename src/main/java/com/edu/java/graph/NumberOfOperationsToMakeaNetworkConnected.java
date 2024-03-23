package com.edu.java.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//LC : 1319
public class NumberOfOperationsToMakeaNetworkConnected {

	public static void main(String[] args) {
		// int n = 6;
		// int[][] connections = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
		int n = 5;
		int[][] connections = { { 0, 1 }, { 0, 2 }, { 3, 4 }, { 2, 3 } };
		int result = makeConnected(n, connections);
		System.out.println(result);
	}

	public static int makeConnected(int n, int[][] connections) {
		if (connections.length < n - 1) return -1;
		Map<Integer, List<Integer>> adj = new HashMap<>();
		for (int[] connection : connections) {
			adj.computeIfAbsent(connection[0], value -> new ArrayList<>()).add(connection[1]);
			adj.computeIfAbsent(connection[1], value -> new ArrayList<>()).add(connection[0]);
		}
		int connectedComponents = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfsFromSource(i, visited, adj);
				connectedComponents++;
			}
		}
		return connectedComponents - 1;
	}

	private static void dfsFromSource(int srcVertex, boolean[] visited, Map<Integer, List<Integer>> adj) {
		visited[srcVertex] = true;
		if (!adj.containsKey(srcVertex)) return;
		List<Integer> connectedVertices = adj.get(srcVertex);
		for (Integer connectedVertex : connectedVertices) {
			if (visited[connectedVertex] == false) {
				dfsFromSource(connectedVertex, visited, adj);
			}
		}

	}

}
