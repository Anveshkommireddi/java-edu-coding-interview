package com.edu.java.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberOfClosedIslands {

	private static final Logger LOGGER = LoggerFactory.getLogger(NumberOfClosedIslands.class);

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 1, 1, 0 },
				{ 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 0 } };
		int result = closedIsland(grid);
		LOGGER.info("Result is {}", result);
	}

	public static int closedIsland(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] vis = new boolean[m][n];
		int count = 0;
		for (int rowIdx = 0; rowIdx < m; rowIdx++) {
			for (int colIdx = 0; colIdx < n; colIdx++) {
				if (grid[rowIdx][colIdx] == 0 && vis[rowIdx][colIdx] == false) {
					boolean isClosed = dfs(grid, rowIdx, colIdx, vis);
					if (isClosed) {
						count++;
					}
				}
			}
		}
		return count;
	}

	private static boolean dfs(int[][] grid, int rowIdx, int colIdx, boolean[][] vis) {

		if (rowIdx < 0 || colIdx < 0 || rowIdx >= grid.length || colIdx >= grid[rowIdx].length) return false;

		if (grid[rowIdx][colIdx] == 1 || vis[rowIdx][colIdx] == true) return true;

		vis[rowIdx][colIdx] = true;
		boolean isClosed = true;
		int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		for (int[] direction : directions) {
			int newX = rowIdx + direction[0];
			int newY = colIdx + direction[1];
			boolean result = dfs(grid, newX, newY, vis);
			if (result == false) {
				return false;
			}
		}
		return true;
	}

}
