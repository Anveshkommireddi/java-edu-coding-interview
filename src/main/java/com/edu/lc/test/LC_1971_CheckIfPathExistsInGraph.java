package com.edu.lc.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LC_1971_CheckIfPathExistsInGraph {

	private static final Logger LOGGER = LoggerFactory.getLogger(LC_1971_CheckIfPathExistsInGraph.class);

	public static void main(String[] args) {
		int n = 10;
		int[][] edges = { { 0, 7 }, { 0, 8 }, { 6, 1 }, { 2, 0 }, { 0, 4 }, { 5, 8 }, { 4, 7 }, { 1, 3 }, { 3, 5 },
				{ 6, 5 } };
		int source = 7;
		int destination = 5;
		boolean validPath = validPath(n, edges, source, destination);
		LOGGER.info("Valid path for the graph is {}", validPath);
	}

	public static boolean validPath(int n, int[][] edges, int source, int destination) {
		List<List<Integer>> adjList = matrixToAdjList(edges, n);
		return pathExists(adjList, source, destination);
	}

	private static boolean pathExists(List<List<Integer>> adjList, int src, int dest) {
		boolean result = false;
		Map<Integer, Boolean> vis = new HashMap<>();
		result = checkFromDFS(adjList, vis, src, dest);
		return result;
	}

	private static boolean checkFromDFS(List<List<Integer>> adjList, Map<Integer, Boolean> vis, int src, int dest) {
		vis.put(src, true);
		if (src == dest)
			return true;
		List<Integer> neighboursList = adjList.get(src);
		for (Integer neighbour : neighboursList) {
			if (vis.getOrDefault(neighbour, false) == false) {
				if (checkFromDFS(adjList, vis, neighbour, dest)) {
					return true;
				}
			}
		}
		return false;
	}

	private static List<List<Integer>> matrixToAdjList(int[][] mat, int n) {
		List<List<Integer>> result = new ArrayList<>();
		for (int vertex = 0; vertex < n; vertex++) {
			result.add(new ArrayList<>());
		}
		for (int rowIdx = 0; rowIdx < mat.length; rowIdx++) {
			int src = mat[rowIdx][0];
			int dest = mat[rowIdx][1];
			result.get(src).add(dest);
			result.get(dest).add(src);
		}
		return result;
	}

}
