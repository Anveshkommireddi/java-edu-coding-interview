package com.edu.lc.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC_01_LargestIsland {
	
	public static void main(String[] args) {
		int[][] matrix = {
		    {1, 0, 1, 0, 0},
		    {0, 0, 1, 1, 0},
		    {0, 1, 1, 1, 1},
		    {0, 1, 1, 0, 0}
		  };
		int islandCounter = 2;
		Map<Integer, Integer> islandCounterMap = new HashMap<>();
		int[][] graph = cloneGraph(matrix);
		for(int rowIdx = 0; rowIdx < graph.length; rowIdx++) {
			for(int colIdx = 0; colIdx < graph[rowIdx].length; colIdx++) {
				if(graph[rowIdx][colIdx] == 1) {
					int[] size = new int[1];
					dfs(graph, rowIdx, colIdx, islandCounter, size);
					islandCounterMap.put(islandCounter, size[0]);
					islandCounter++;
				}
			}
		}
		
		int result = Integer.MIN_VALUE;
		for(int rowIdx = 0; rowIdx < graph.length; rowIdx++) {
			for(int colIdx = 0; colIdx < graph[0].length; colIdx++) {
				if(graph[rowIdx][colIdx] == 0) {
					int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
					Set<Integer> islandMapperSet = new HashSet<>();
					for(int[] direction : directions) {
						int newX = direction[0] + rowIdx;
						int newY = direction[1] + colIdx;
						if(newX >= 0 && newY >= 0 && newX < graph.length && newY < graph[newX].length && graph[newX][newY] > 1) {
							islandMapperSet.add(graph[newX][newY]);
						}
					}
					int currResult = 1;
					for(Integer islandMapperVal : islandMapperSet) {
						currResult += islandCounterMap.get(islandMapperVal);
					}
					result = Math.max(result, currResult);
				}
			}
		}
		System.out.println(result);
	}

	private static void dfs(int[][] graph, int rowIdx, int colIdx, int islandCounter, int[] size) {
		graph[rowIdx][colIdx] = islandCounter;
		size[0]++;
		int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		for(int[] direction : directions) {
			int newX = direction[0] + rowIdx;
			int newY = direction[1] + colIdx;
			if(newX >= 0 && newY >= 0 && newX < graph.length && newY < graph[newX].length && graph[newX][newY] == 1) {
				  dfs(graph, newX, newY, islandCounter, size);
			}
		}
	}

	private static int[][] cloneGraph(int[][] matrix) {
		int[][] graph = new int[matrix.length][matrix[0].length];
		for(int rowIdx = 0; rowIdx < matrix.length; rowIdx++) {
			for(int colIdx = 0; colIdx < matrix[rowIdx].length; colIdx++) {
				graph[rowIdx][colIdx] = matrix[rowIdx][colIdx];
			}
		}
		return graph;
	}

}
