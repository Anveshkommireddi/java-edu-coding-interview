package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DP_11_TriangleSum {

	private static final Logger LOGGER = LoggerFactory.getLogger(DP_11_TriangleSum.class);
	
	private static final int MOD = Double.valueOf(Math.pow(10, 9) + 7).intValue();

	public static void main(String[] args) {
		int[][] grid = { 
				        { 1 }, 
				        { 2, 3 },
				        { 3, 6, 7 },
				        { 8, 9, 6, 10}};
		int result = Integer.MAX_VALUE;
		int rowIdx = grid.length - 1;
		int totalCols = grid[rowIdx].length;
		for(int colIdx = 0; colIdx < totalCols; colIdx++) {
			//result = Math.min(result, minPathSum(grid, rowIdx, colIdx));
		}
		result = minPathSum1(grid, 0, 0);
		LOGGER.info("Minimum Path Sum is {}", result);
	}
	
	private static int minPathSum1(int[][] grid, int rowIdx, int colIdx) {
		if (rowIdx == grid.length - 1)
			return grid[rowIdx][colIdx];
		int down = grid[rowIdx][colIdx] + minPathSum1(grid, rowIdx + 1, colIdx);
		int downDiagnol = grid[rowIdx][colIdx] + minPathSum1(grid, rowIdx + 1, colIdx + 1);
		return Math.min(down, downDiagnol);
	}

	//move down (row+1, col) or move to right diagnoal (row + 1, col + 1)
	// end at the last row
	private static int minPathSum(int[][] grid, int rowIdx, int colIdx) {
		if (rowIdx == 0 && colIdx == 0) {
			return grid[rowIdx][colIdx];
		}
		
		if(rowIdx < 0 || colIdx < 0) return MOD;
		
		if(rowIdx >= 0 && rowIdx < grid.length && colIdx > grid[rowIdx].length - 1) return MOD;
		
		int up = grid[rowIdx][colIdx] + minPathSum(grid, rowIdx - 1, colIdx);
		int upDiagnal = grid[rowIdx][colIdx] + minPathSum(grid, rowIdx-1, colIdx-1);
		return Math.min(upDiagnal, up);
	}
}
