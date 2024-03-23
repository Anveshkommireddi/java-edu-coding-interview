package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_09_GridUniquePaths2 {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_09_GridUniquePaths2.class);

	public static void main(String[] args) {
		int[][] grid = { 
				{ 0, 0, 0 }, 
				{ 0, -1, 0 }, 
				{ 0, 0, 0 }};
		int totalPathRec = unqPathsRec(grid, grid.length - 1, grid[0].length - 1);
		LOGGER.info("Total Unique Paths with Obstacles using recursion is {}", totalPathRec);
		Integer[][] mem = new Integer[grid.length][grid[0].length];
		int totalPathMem = unqPathsMem(grid, grid.length - 1, grid[0].length - 1, mem);
		LOGGER.info("Total Unique Paths with Obstacles using Memoization is {}", totalPathMem);
	}

	private static int unqPathsMem(int[][] grid, int rowIdx, int colIdx, Integer[][] mem) {
		if(isValidCell(grid, rowIdx, colIdx) && grid[rowIdx][colIdx] == -1) return 0;
		if(rowIdx == 0 && colIdx == 0) return 1;
		if (rowIdx < 0 || colIdx < 0) return 0;
		if(null != mem[rowIdx][colIdx]) return mem[rowIdx][colIdx];
		int top = unqPathsRec(grid, rowIdx - 1, colIdx);
		int left = unqPathsRec(grid, rowIdx, colIdx - 1);
		return mem[rowIdx][colIdx] = top + left;
	}

	private static int unqPathsRec(int[][] grid, int rowIdx, int colIdx) {
		if(isValidCell(grid, rowIdx, colIdx) && grid[rowIdx][colIdx] == -1) return 0;
		if(rowIdx == 0 && colIdx == 0) return 1;
		if (rowIdx < 0 || colIdx < 0) return 0;
		int top = unqPathsRec(grid, rowIdx - 1, colIdx);
		int left = unqPathsRec(grid, rowIdx, colIdx - 1);
		return top + left;
	}

	
	private static boolean isValidCell(int[][] grid, int rowIdx, int colIdx) {
		return rowIdx > 0 && colIdx > 0 && rowIdx < grid.length && colIdx < grid[0].length - 1;
	}
}
