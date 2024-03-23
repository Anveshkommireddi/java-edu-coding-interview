package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_10_MinimumPathSumInGrid {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DP_10_MinimumPathSumInGrid.class);
	private static final int MOD = Double.valueOf(Math.pow(10, 9) + 7).intValue();
	
	public static void main(String[] args) {
		int[][] grid = { { 5, 9, 6 }, { 11, 5, 2 } };
		int minimumSum = minPathSum(grid, grid.length-1, grid[0].length-1);
		LOGGER.info("Minium Path Sum is {}", minimumSum);
		Integer[][] mem = new Integer[grid.length][grid[0].length];
		int minimumSumMem = minPathSumMem(grid, grid.length-1, grid[0].length-1, mem);
		LOGGER.info("Minium Path Sum Mem is {}", minimumSumMem);
		int minimumSumBottomsUp = minPathSumBottomsUp(grid);
		LOGGER.info("Minium Path Sum BottomsUp is {}", minimumSumBottomsUp);
	}
	
	private static int minPathSumBottomsUp(int[][] grid) {
		int totalRows = grid.length;
		int totalCols = grid[0].length;
		Integer[][] mem = new Integer[totalRows][totalCols];
		for (int rowIdx = 0; rowIdx < totalRows; rowIdx++) {
			for (int colIdx = 0; colIdx < totalCols; colIdx++) {
				if (rowIdx == 0 && colIdx == 0) {
					mem[rowIdx][colIdx] = grid[rowIdx][colIdx];
				} else {

					int left = grid[rowIdx][colIdx];
					left += colIdx - 1 >= 0 ? mem[rowIdx][colIdx - 1] : MOD;

					int top = grid[rowIdx][colIdx];
					top += rowIdx - 1 >= 0 ? mem[rowIdx - 1][colIdx] : MOD;

					mem[rowIdx][colIdx] = Math.min(left, top);
				}
			}
		}
		return mem[totalRows - 1][totalCols - 1];
	}
	
	private static int minPathSumMem(int[][] grid, int rowIdx, int colIdx, Integer[][] mem) {
		if(rowIdx == 0 && colIdx == 0) return grid[rowIdx][colIdx];
		if(rowIdx < 0 || colIdx < 0) return MOD;
		if(null != mem[rowIdx][colIdx]) return mem[rowIdx][colIdx];
		int left = grid[rowIdx][colIdx] + minPathSumMem(grid, rowIdx, colIdx - 1, mem);
		int top = grid[rowIdx][colIdx] + minPathSumMem(grid, rowIdx - 1, colIdx, mem);
		return mem[rowIdx][colIdx] = Math.min(left, top);
	}

	private static int minPathSum(int[][] grid, int rowIdx, int colIdx) {
		if(rowIdx == 0 && colIdx == 0) return grid[rowIdx][colIdx];
		if(rowIdx < 0 || colIdx < 0) return MOD;
		int left = grid[rowIdx][colIdx] + minPathSum(grid, rowIdx, colIdx - 1);
		int top = grid[rowIdx][colIdx] + minPathSum(grid, rowIdx - 1, colIdx);
		return Math.min(left, top);
	}

}
