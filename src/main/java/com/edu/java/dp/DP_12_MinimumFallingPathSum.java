package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//lc - 931
public class DP_12_MinimumFallingPathSum {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DP_12_MinimumFallingPathSum.class);

	public static void main(String[] args) {

		int[][] mat = { 
				{ 2, 1, 3 }, 
				{ 6, 5, 4 }, 
				{ 7, 8, 9 } };
        //output : 7 + 5 + 1
		int rowIdx = mat.length - 1;
		Integer minSum = Double.valueOf(Math.pow(10, 9)).intValue();
		Integer[][] mem = new Integer[rowIdx + 1][mat[rowIdx].length + 1];
		/**
		 * target reaches end row and do the same for every column in the last row
		 * find the minimum for all the columns in the last row
		 */
		for (int colIdx = 0; colIdx < mat[rowIdx].length; colIdx++) {
			minSum = Math.min(minSum, minimalFallingSumHelperMem(mat, rowIdx, colIdx, mem));
		}
		LOGGER.info("Minimum Sum Mem is ;; {}", minSum);
	}
	
	/**
	 * minimalFallingSumHelperMem move up for the dimensions { -1, 0 }, { -1, 1 }, { -1, -1 }
	 * and find the minimum sum of all the above rows 
	 * base conditions if row is zero , then return rowIdx colIdx value or return max value
	 */
	private static int minimalFallingSumHelperMem(int[][] mat, int rowIdx, int colIdx, Integer[][] mem) {

		if (rowIdx == 0 && colIdx >= 0 && colIdx < mat[rowIdx].length) return mat[rowIdx][colIdx];

		if (rowIdx < 0 || colIdx < 0 || colIdx >= mat[rowIdx].length) return Double.valueOf(Math.pow(10, 9)).intValue();

		if (null != mem[rowIdx][colIdx]) return mem[rowIdx][colIdx];
		
		int result = Double.valueOf(Math.pow(10, 9)).intValue();

		int[][] dimensions = { { -1, 0 }, { -1, 1 }, { -1, -1 } };

		for (int[] dimension : dimensions) {
			int newRowIdx = rowIdx + dimension[0];
			int newColIdx = colIdx + dimension[1];
			result = Math.min(result, minimalFallingSumHelperMem(mat, newRowIdx, newColIdx, mem));
		}

		return mem[rowIdx][colIdx] = mat[rowIdx][colIdx] + result;
	}
}
