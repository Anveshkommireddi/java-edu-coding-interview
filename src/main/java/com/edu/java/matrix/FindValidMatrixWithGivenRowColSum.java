package com.edu.java.matrix;

import java.util.Arrays;

//LC : 1605
public class FindValidMatrixWithGivenRowColSum {

	public static void main(String[] args) {
		// int[] rowSum = { 3, 8 };
		// int[] colSum = { 4, 7 };
		int[] rowSum = { 5, 7, 10 };
		int[] colSum = { 8, 6, 8 };
		int[] dupRowSum = Arrays.copyOfRange(rowSum, 0, rowSum.length);
		int[] dupColSum = Arrays.copyOfRange(colSum, 0, colSum.length);
		int[][] rolColMat = generateMatrix(dupRowSum, dupColSum);
		System.out.println(rolColMat);
	}

	private static int[][] generateMatrix(int[] rowSum, int[] colSum) {
		int[][] result = new int[rowSum.length][colSum.length];
		for (int rowIdx = 0; rowIdx < result.length; rowIdx++) {
			for (int colIdx = 0; colIdx < result[rowIdx].length; colIdx++) {
				int currRowSum = rowSum[rowIdx];
				int currColSum = colSum[colIdx];
				int currVal = Math.min(currRowSum, currColSum);
				rowSum[rowIdx] = currRowSum - currVal;
				colSum[colIdx] = currColSum - currVal;
				result[rowIdx][colIdx] = currVal;
			}
		}
		return result;
	}

}
