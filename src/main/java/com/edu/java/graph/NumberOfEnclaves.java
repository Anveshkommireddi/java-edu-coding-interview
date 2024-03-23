package com.edu.java.graph;

import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberOfEnclaves {

	private static final Logger LOGGER = LoggerFactory.getLogger(NumberOfEnclaves.class);

	public static void main(String[] args) {
		//int[][] graph = { { 0, 0, 0, 0, 1 }, { 0, 0, 1, 1, 0 }, { 0, 1, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
		int[][] graph = { { 1, 1 }, { 1, 0 } };
		//int numberOfEnclaves = getNumberOfEnclaves(graph);
		int numberOfEnclaves = numEnclaves(graph);
		LOGGER.info("Number Of Enclaves are {}", numberOfEnclaves);
	}

	public static int numEnclaves(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] vis = new boolean[m][n];
		int borderOnes = 0;
		int totalOnes = 0;
		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				totalOnes += grid[row][col];
				if (row == 0 || row == m - 1 || col == 0 || col == n - 1) {
					if (grid[row][col] == 1 && vis[row][col] == false) {
						borderOnes += dfs(grid, row, col, vis);
					}
				}
			}
		}
		System.out.println("Border Ones is " + borderOnes);
		System.out.println("Total Ones is " + totalOnes);
		return totalOnes - borderOnes;
	}

	private static int dfs(int[][] grid, int row, int col, boolean[][] vis) {
		vis[row][col] = true;
		int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		int result = 1;
		for (int[] direction : directions) {
			int newX = direction[0] + row;
			int newY = direction[1] + col;
			if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[newX].length && vis[newX][newY] == false
					&& grid[newX][newY] == 1) {
				result += dfs(grid, newX, newY, vis);
			}
		}
		return result;
	}

	private static int getNumberOfEnclaves(int[][] graph) {
		int numberOfEnclaves = 0;
		int rows = graph.length;
		int cols = graph[0].length;
		int[][] visited = new int[rows][cols];
		Queue<Pair> queue = new LinkedList<>();
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (row == 0 || row == rows - 1 || col == 0 || col == cols - 1) {
					if (graph[row][col] == 1) {
						visited[row][col] = 1;
						queue.add(new Pair(row, col));
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			Pair node = queue.poll();
			int srcRow = node.rowIdx;
			int srcCol = node.colIdx;
			int[][] directions = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
			for (int[] direction : directions) {
				int row = direction[0];
				int col = direction[1];
				int nRow = srcRow + row;
				int nCol = srcCol + col;
				if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && visited[nRow][nCol] == 0
						&& graph[nRow][nCol] == 1) {
					visited[nRow][nCol] = 1;
					queue.add(new Pair(nRow, nCol));
				}
			}
		}

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (graph[row][col] == 1 && visited[row][col] == 0)
					numberOfEnclaves++;
			}
		}
		return numberOfEnclaves;
	}

}
