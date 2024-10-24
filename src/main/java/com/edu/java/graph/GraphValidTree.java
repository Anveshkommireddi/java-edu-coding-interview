package com.edu.java.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {

	public static void main(String[] args) {
		int n = 5;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
		// int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
		boolean isValid = validTree(n, edges);
		System.out.println(isValid);
	}

	public static boolean validTree(int n, int[][] edges) {
		List<List<Integer>> adjList = createAdjacencyList(n, edges);
		boolean[] vis = new boolean[n];
		int connectedComponents = 0;
		for (int vertex = 0; vertex < n; vertex++) {
			if (vis[vertex] == false) {
				boolean hasCycle = dfs(adjList, vis, vertex, -1);
				connectedComponents++;
				if (hasCycle || connectedComponents > 1) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean dfs(List<List<Integer>> adjList, boolean[] vis, int srcVertex, int parent) {
		vis[srcVertex] = true;
		List<Integer> neighbors = adjList.get(srcVertex);
		for (Integer neighbor : neighbors) {
			if (vis[neighbor] == false) {
				boolean tempCycle = dfs(adjList, vis, neighbor, srcVertex);
				if (tempCycle) {
					return true;
				}
			} else if (parent != neighbor) {
				return true;
			}
		}
		return false;
	}

	private static List<List<Integer>> createAdjacencyList(int n, int[][] edges) {
		List<List<Integer>> adjList = new ArrayList<>();
		for (int vertex = 0; vertex < n; vertex++) {
			adjList.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			int from = edge[0];
			int to = edge[1];
			adjList.get(from).add(to);
			adjList.get(to).add(from);
		}
		return adjList;
	}

}
