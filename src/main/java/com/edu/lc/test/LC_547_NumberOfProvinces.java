package com.edu.lc.test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LC_547_NumberOfProvinces {

	private static final Logger LOGGER = LoggerFactory.getLogger(LC_1971_CheckIfPathExistsInGraph.class);

	public static void main(String[] args) {
		int[][] graph = { { 1, 0, 0, 1 }, 
				          { 0, 1, 1, 0 }, 
				          { 0, 1, 1, 1 }, 
				          { 1, 0, 1, 1 } };
		// int connectedComponents = getNumberOfProvinces(graph);
		// LOGGER.info("Number Of Connected Components is {}", connectedComponents);
		List<List<Integer>> adjLst = getAdjacencyList(graph);
		int connectedComponents = getNumberOfProvinces(adjLst);
		LOGGER.info("Number Of Connected Components from adjacency List is {}", connectedComponents);
	}

	private static int getNumberOfProvinces(List<List<Integer>> adjLst) {
		int result = 0;
		int totalVerticies = adjLst.size();
		boolean[] vis = new boolean[totalVerticies];
		for (int vertex = 0; vertex < totalVerticies; vertex++) {
			if (vis[vertex] == false) {
				dfs(adjLst, vis, vertex);
				result++;
			}
		}
		return result;
	}

	private static void dfs(List<List<Integer>> adjLst, boolean[] vis, int currVertex) {
		vis[currVertex] = true;
		List<Integer> neighborsList = adjLst.get(currVertex);
		for (Integer neighbor : neighborsList) {
			if (vis[neighbor] == false) {
				dfs(adjLst, vis, neighbor);
			}
		}
	}

	private static List<List<Integer>> getAdjacencyList(int[][] graph) {
		int totalVertices = graph.length;
		List<List<Integer>> result = new ArrayList<>();
		for (int vertex = 0; vertex < totalVertices; vertex++) {
			result.add(new ArrayList<>());
		}
		for (int rowIdx = 0; rowIdx < totalVertices; rowIdx++) {
			for (int colIdx = 0; colIdx < totalVertices; colIdx++) {
				if (rowIdx != colIdx && graph[rowIdx][colIdx] == 1) {
					result.get(rowIdx).add(colIdx);
				}
			}
		}
		return result;
	}

}
