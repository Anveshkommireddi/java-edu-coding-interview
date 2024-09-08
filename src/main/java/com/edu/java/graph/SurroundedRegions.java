package com.edu.java.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SurroundedRegions {
	
private static final Logger LOGGER = LoggerFactory.getLogger(SurroundedRegions.class);
	
	public static void main(String[] args) {
		char[][] input = { { 'X', 'X', 'X', 'X', 'X' }, 
				  		   { 'X', 'O', 'O', 'X', 'O' }, 
				  		   { 'X', 'X', 'O', 'X', 'O' }, 
				  		   { 'X', 'O', 'X', 'O', 'X' },
				  		   { 'O', 'O', 'X', 'X', 'X' }};
		char[][] graph = convertSurroundedOsToX(input);
		System.out.println(graph);
	}

	private static char[][] convertSurroundedOsToX(char[][] input) {
		char[][] graph = cloneInput(input);
		boolean[][] visited = new boolean[graph.length][graph[0].length];
		// traverse around that boundaries
		for (int colIdx = 0; colIdx < graph[0].length; colIdx++) {
			// for 1st row
			if (graph[0][colIdx] == 'O' && visited[0][colIdx] == false) {
				dfs(graph, visited, 0, colIdx);
			}
			// for last row
			if (graph[graph.length - 1][colIdx] == 'O' && visited[graph.length - 1][colIdx] == false) {
				dfs(graph, visited, graph.length - 1, colIdx);
			}
		}

		for (int rowIdx = 0; rowIdx < graph.length; rowIdx++) {
			// for 1st col
			if (graph[rowIdx][0] == 'O' && visited[rowIdx][0] == false) {
				dfs(graph, visited, rowIdx, 0);
			}
			// for last col
			if (graph[rowIdx][graph[0].length - 1] == 'O' && visited[rowIdx][graph[0].length - 1] == false) {
				dfs(graph, visited, rowIdx, graph[0].length - 1);
			}
		}

		for (int rowIdx = 0; rowIdx < graph.length; rowIdx++) {
			for (int colIdx = 0; colIdx < graph[0].length; colIdx++) {
				if (graph[rowIdx][colIdx] == 'O' && visited[rowIdx][colIdx] == false) {
					graph[rowIdx][colIdx] = 'X';
				}
			}
		}

		return graph;
	}

	private static void dfs(char[][] graph, boolean[][] visited, int rowIdx, int colIdx) {
		visited[rowIdx][colIdx] = true;
		int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		for (int[] direction : directions) {
			int newRowIdx = direction[0] + rowIdx;
			int newColIdx = direction[1] + colIdx;
			if (newRowIdx >= 0 && newRowIdx < graph.length && newColIdx >= 0 && newColIdx < graph[0].length
					&& graph[newRowIdx][newColIdx] == 'O' && visited[newRowIdx][newColIdx] == false) {
				dfs(graph, visited, newRowIdx, newColIdx);
			}
		}
	}

	private static char[][] cloneInput(char[][] input) {
		char[][] graph = new char[input.length][input[0].length];
		for (int rowIdx = 0; rowIdx < input.length; rowIdx++) {
			for (int colIdx = 0; colIdx < input[rowIdx].length; colIdx++) {
				graph[rowIdx][colIdx] = input[rowIdx][colIdx];
			}
		}
		return graph;
	}

}
