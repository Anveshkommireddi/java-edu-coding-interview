package com.edu.java.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberOfDistinctIslands {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NumberOfDistinctIslands.class);
	
	public static void main(String[] args) {
		int[][] input = { { 1, 1, 0, 1, 1 }, 
						  { 1, 0, 0, 0, 0 }, 
				          { 0, 0, 0, 0, 1 }, 
				          { 1, 1, 0, 1, 1 } };
		int numOfDistinctIslands = findNumberOfDistinctIslands(input);
		LOGGER.info("Number of Distinct Islands are {}", numOfDistinctIslands);
	}

	private static int findNumberOfDistinctIslands(int[][] input) {
		int[][] graph = cloneInputGraph(input);
		boolean[][] vis = new boolean[graph.length][graph[0].length];
		Set<List<Pair>> distinctIslandsSet = new HashSet<>();
		for(int rowIdx = 0; rowIdx < input.length; rowIdx++) {
			for(int colIdx = 0; colIdx < input[0].length; colIdx++) {
				if(graph[rowIdx][colIdx]== 1 && vis[rowIdx][colIdx] == false) {
					List<Pair> islandsPathList = new ArrayList<>();
					dfs(graph, vis, islandsPathList, rowIdx, colIdx, rowIdx, colIdx);
					distinctIslandsSet.add(islandsPathList);
				}
			}
		}
		return distinctIslandsSet.size();
	}

	private static void dfs(int[][] graph, boolean[][] vis, List<Pair> islandsPathList, int rowIdx, int colIdx,
			int srcRowIdx, int srcColIdx) {
		vis[rowIdx][colIdx] = true;
		islandsPathList.add(new Pair(srcRowIdx - rowIdx, srcColIdx - colIdx));

		int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		for (int[] direction : directions) {
			int newRowIdx = rowIdx + direction[0];
			int newColIdx = colIdx + direction[1];
			if (newRowIdx >= 0 && newRowIdx < graph.length && newColIdx >= 0 && newColIdx < graph[0].length
					&& vis[newRowIdx][newColIdx] == false && graph[newRowIdx][newColIdx] == 1) {
				dfs(graph, vis, islandsPathList, newRowIdx, newColIdx, srcRowIdx, srcColIdx);
			}
		}
	}

	private static int[][] cloneInputGraph(int[][] input) {
		int[][] graph = new int[input.length][input[0].length];
		for (int rowIdx = 0; rowIdx < input.length; rowIdx++) {
			for (int colIdx = 0; colIdx < input[0].length; colIdx++) {
				graph[rowIdx][colIdx] = input[rowIdx][colIdx];
			}
		}
		return graph;
	}

}
