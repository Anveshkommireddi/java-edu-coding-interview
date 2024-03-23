package com.edu.java.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//LC :: 2492
public class MinScorePathBetweenTwoCities {

	public static void main(String[] args) {
		int n = 4;
		int[][] roads = { { 1, 2, 9 }, { 2, 3, 6 }, { 2, 4, 5 }, { 1, 4, 7 } };
		//int[][] roads = { { 1, 2, 2 }, { 1, 3, 4 }, { 3, 4, 7 } };
		List<List<GraphNode>> adjList = getAdjacencyList(roads, n);
		int[] res = new int[1];
		Arrays.fill(res, Integer.MAX_VALUE);
		dfs(adjList, n, res);
		System.out.println(res[0]);
	}

	private static void dfs(List<List<GraphNode>> adjList, int n, int[] res) {
		int srcVertex = 1;
		int tgtVertex = n;
		boolean[] visited = new boolean[n + 1];
		dfsFromSource(srcVertex, tgtVertex, adjList, res, visited);
	}
	
	private static void dfsFromSource(int srcVertex, int tgtVertex, List<List<GraphNode>> adjList, int[] res, boolean[] visited) {
		if(visited[srcVertex]) return;
		visited[srcVertex] = true;

		List<GraphNode> connectedNodesList = adjList.get(srcVertex);
		for (GraphNode connectedVertex : connectedNodesList) {
			dfsFromSource(connectedVertex.toVertex, tgtVertex, adjList, res, visited);
			res[0] = Math.min(res[0], connectedVertex.weight);
		
		}
	}

	private static List<List<GraphNode>> getAdjacencyList(int[][] roads, int n) {
		List<List<GraphNode>> adjList = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int rowIdx = 0; rowIdx < roads.length; rowIdx++) {
			int[] edgeInfo = roads[rowIdx];
			int fromIdx = edgeInfo[0];
			int toIdx = edgeInfo[1];
			int distance = edgeInfo[2];
			GraphNode graphNode1 = new GraphNode(fromIdx, toIdx, distance);
			adjList.get(fromIdx).add(graphNode1);
			GraphNode graphNode2 = new GraphNode(toIdx, fromIdx, distance);
			adjList.get(toIdx).add(graphNode2);
		}
		return adjList;
	}
}
