package com.edu.java.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//lC : 2316
public class CountUnReachablePairOfNodesInUndirectedGraph {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountUnReachablePairOfNodesInUndirectedGraph.class);

	public static void main(String[] args) {
		int n = 7;
		int[][] edges = { { 0, 2 }, { 0, 5 }, { 2, 4 }, { 1, 6 }, { 5, 4 } };
		int totalPairs = countPairs(n, edges);
		LOGGER.info("Totatl UnReachable Pairs {}", totalPairs);
	}

	private static int countPairs(int totalVertices, int[][] edges) {
		Map<Integer, List<Integer>> adj = new HashMap<>();
		for (int[] edge : edges) {
			adj.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
			adj.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
		}
		int numOfPairs = 0;
		int remainingVertices = totalVertices;
		boolean[] vis = new boolean[totalVertices];
		for (int vertex = 0; vertex < totalVertices; vertex++) {
			if (vis[vertex] == false) {
				int countOfConnectedVertices = dfsFromSource(adj, vertex, vis);
				numOfPairs += countOfConnectedVertices * (remainingVertices - countOfConnectedVertices);
				remainingVertices -= countOfConnectedVertices;
			}
		}
		return numOfPairs;
	}

	private static int dfsFromSource(Map<Integer, List<Integer>> adj, int src, boolean[] vis) {
		vis[src] = true;
		int count = 1;
		if (!adj.containsKey(src)) return count;
		List<Integer> connectedVertices = adj.get(src);
		for (Integer connectedVertex : connectedVertices) {
			if (vis[connectedVertex] == false) {
				count += dfsFromSource(adj, connectedVertex, vis);
			}
		}
		return count;
	}

}
