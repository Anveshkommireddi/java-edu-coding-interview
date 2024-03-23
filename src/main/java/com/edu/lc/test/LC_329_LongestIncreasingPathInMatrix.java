package com.edu.lc.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LC_329_LongestIncreasingPathInMatrix {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LC_329_LongestIncreasingPathInMatrix.class);
	
	public static void main(String[] args) {
		int[][] mat = {
				{9, 9, 4},
				{6, 6, 8},
				{2, 1, 1}
		};
		int maxLength = maxLISInMatrix(mat);
		LOGGER.info("Max Length of Longest Increaing Path in Matrix is {}", maxLength);
	}

	private static int maxLISInMatrix(int[][] mat) {
		int rows = mat.length;
		int cols = mat[0].length;
		int[][] cache = new int[rows][cols];
		int result = Integer.MIN_VALUE;
		for (int rowIdx = 0; rowIdx < rows; rowIdx++) {
			for (int colIdx = 0; colIdx < cols; colIdx++) {
				int lisFromRowCol = findLISInMat(mat, rowIdx, colIdx, cache);
				result = Math.max(result, lisFromRowCol);
			}
		}
		return result;
	}

	private static int findLISInMat(int[][] mat, int rowIdx, int colIdx, int[][] cache) {
		if (cache[rowIdx][colIdx] != 0)
			return cache[rowIdx][colIdx];
		int result = 0;
		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int[] dir : directions) {
			int newX = dir[0] + rowIdx;
			int newY = dir[1] + colIdx;
			if (isValid(mat, newX, newY) && mat[rowIdx][colIdx] < mat[newX][newY]) {
				int dirResult = findLISInMat(mat, newX, newY, cache);
				result = Math.max(result, dirResult);
			}
		}
		return cache[rowIdx][colIdx] = 1 + result;
	}

	private static boolean isValid(int[][] mat, int rowIdx, int colIdx) {
		int rows = mat.length;
		int cols = mat[0].length;
		return rowIdx >= 0 && colIdx >= 0 && rowIdx < rows && colIdx < cols;
	}

}
