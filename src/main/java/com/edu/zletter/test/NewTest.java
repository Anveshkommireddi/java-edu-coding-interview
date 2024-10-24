package com.edu.zletter.test;

public class NewTest {

	public static void main(String[] args) {
		int[][] mat = { { 0, 0, 1 }, 
					    { 0, 1, 1 }, 
					    { 1, 0, 1 } };
		int[] nums = {-2, 0, -1};
		Integer[][] result = updateMatrix(mat);
		System.out.println(result);
	}

	public static Integer[][] updateMatrix(int[][] mat) {
		int rows = mat.length;
		int cols = mat[0].length;
		Integer[][] res = new Integer[rows][cols];
		for (int rowIdx = 0; rowIdx < rows; rowIdx++) {
			for (int colIdx = 0; colIdx < cols; colIdx++) {
				if (mat[rowIdx][colIdx] == 0) {
					res[rowIdx][colIdx] = 0;
				}
			}
		}
		for (int rowIdx = 0; rowIdx < rows; rowIdx++) {
			for (int colIdx = 0; colIdx < cols; colIdx++) {
				if (mat[rowIdx][colIdx] == 1) {
					res[rowIdx][colIdx] = dfs(mat, res, rowIdx, colIdx);
				}
			}
		}
		return res;
	}

	private static int dfs(int[][] mat, Integer[][] res, int rowIdx, int colIdx) {
		if (rowIdx < 0 || colIdx < 0 || rowIdx >= mat.length || colIdx >= mat[0].length) {
			return Integer.MAX_VALUE;
		}
		if (mat[rowIdx][colIdx] == 0) {
			return 0;
		}
		if (null != res[rowIdx][colIdx]) {
			return res[rowIdx][colIdx];
		}
		//res[rowIdx][colIdx] = Integer.MAX_VALUE;
		int minDist = Integer.MAX_VALUE;
		int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		for (int[] direction : directions) {
			int newX = direction[0] + rowIdx;
			int newY = direction[1] + colIdx;
			if (newX >= 0 && newX < mat.length && newY >= 0 && newY < mat[newX].length) {
				int tempDist = dfs(mat, res, newX, newY);
	            if (tempDist != Integer.MAX_VALUE) { // Valid path
	                minDist = Math.min(minDist, 1 + tempDist);
	            }
			}
		}
		return res[rowIdx][colIdx] = minDist;
	}

}
