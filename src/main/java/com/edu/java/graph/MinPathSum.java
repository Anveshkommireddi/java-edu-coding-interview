package com.edu.java.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//LC : 64
public class MinPathSum {

	private static final Logger LOGGER = LoggerFactory.getLogger(MinPathSum.class);

	public static void main(String[] args) {
		// int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		// int[][] grid = { { 1, 3 }, { 1, 5 } };
		// int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] grid = { { 5, 0, 1, 1, 2, 1, 0, 1, 3, 6, 3, 0, 7, 3, 3, 3, 1 },
				{ 1, 4, 1, 8, 5, 5, 5, 6, 8, 7, 0, 4, 3, 9, 9, 6, 0 },
				{ 2, 8, 3, 3, 1, 6, 1, 4, 9, 0, 9, 2, 3, 3, 3, 8, 4 },
				{ 3, 5, 1, 9, 3, 0, 8, 3, 4, 3, 4, 6, 9, 6, 8, 9, 9 },
				{ 3, 0, 7, 4, 6, 6, 4, 6, 8, 8, 9, 3, 8, 3, 9, 3, 4 },
				{ 8, 8, 6, 8, 3, 3, 1, 7, 9, 3, 3, 9, 2, 4, 3, 5, 1 },
				{ 7, 1, 0, 4, 7, 8, 4, 6, 4, 2, 1, 3, 7, 8, 3, 5, 4 },
				{ 3, 0, 9, 6, 7, 8, 9, 2, 0, 4, 6, 3, 9, 7, 2, 0, 7 },
				{ 8, 0, 8, 2, 6, 4, 4, 0, 9, 3, 8, 4, 0, 4, 7, 0, 4 },
				{ 3, 7, 4, 5, 9, 4, 9, 7, 9, 8, 7, 4, 0, 4, 2, 0, 4 },
				{ 5, 9, 0, 1, 9, 1, 5, 9, 5, 5, 3, 4, 6, 9, 8, 5, 6 },
				{ 5, 7, 2, 4, 4, 4, 2, 1, 8, 4, 8, 0, 5, 4, 7, 4, 7 },
				{ 9, 5, 8, 6, 4, 4, 3, 9, 8, 1, 1, 8, 7, 7, 3, 6, 9 },
				{ 7, 2, 3, 1, 6, 3, 6, 6, 6, 3, 2, 3, 9, 9, 4, 4, 8 } };
		// int minPathSum = minPathSum(grid);
		long startTime = System.currentTimeMillis();
		boolean[][] vis = new boolean[grid.length][grid[0].length];
		Integer[][] mem = new Integer[grid.length+1][grid[0].length+1];
		int minPathSum = dfs(grid, vis, 0, 0, grid.length - 1, grid[0].length - 1, mem);
		LOGGER.info("Total Time Executed is {} sec", (System.currentTimeMillis() - startTime )/1000);
		System.out.println(minPathSum);
	}

	private static int minPathSum(int[][] grid) {
		int totalRows = grid.length;
		int totalCols = grid[0].length;
		boolean[][] visited = new boolean[totalRows][totalCols];
		int result = dfsFromSource(grid, 0, 0, totalRows - 1, totalCols - 1, visited);
		return result;
	}

	private static int dfs(int[][] grid, boolean[][] vis, int rowIdx, int colIdx, int tgtRowIdx, int tgtColIdx, Integer[][] mem) {
		if (rowIdx == tgtRowIdx && colIdx == tgtColIdx) {
			return grid[rowIdx][colIdx];
		}
		if(null != mem[rowIdx][colIdx]) return mem[rowIdx][colIdx];
		vis[rowIdx][colIdx] = true;
		int minPathSum = 10000000;
		int[][] directions = { { 0, 1 }, { 1, 0 } };
		for (int[] direction : directions) {
			int newRowIdx = rowIdx + direction[0];
			int newColIdx = colIdx + direction[1];
			if (newRowIdx <= tgtRowIdx && newColIdx <= tgtColIdx && vis[newRowIdx][newColIdx] == false) {
				int dfsSum = grid[rowIdx][colIdx] + dfs(grid, vis, newRowIdx, newColIdx, tgtRowIdx, tgtColIdx, mem);
				minPathSum = Math.min(minPathSum, dfsSum);
			}
		}
		vis[rowIdx][colIdx] = false;
		return mem[rowIdx][colIdx] = minPathSum;
	}

	private static int dfsFromSource(int[][] grid, int rowIdx, int colIdx, int tgtRowIdx, int tgtColIdx,
			boolean[][] visited) {
		if (rowIdx == tgtRowIdx && colIdx == tgtColIdx) {
			return grid[rowIdx][colIdx];
		}
		visited[rowIdx][colIdx] = true;
		int[][] directions = { { 0, 1 }, { 1, 0 } };
		int totalPathSum = 10000000;
		for (int[] direction : directions) {
			int newRowIdx = rowIdx + direction[0];
			int newColIdx = colIdx + direction[1];
			if (newRowIdx <= tgtRowIdx && newColIdx <= tgtColIdx && visited[newRowIdx][newColIdx] == false) {
				int dfsSum = grid[rowIdx][colIdx]
						+ dfsFromSource(grid, newRowIdx, newColIdx, tgtRowIdx, tgtColIdx, visited);
				totalPathSum = Math.min(dfsSum, totalPathSum);
			}
		}
		visited[rowIdx][colIdx] = false;
		return totalPathSum;
	}

}
