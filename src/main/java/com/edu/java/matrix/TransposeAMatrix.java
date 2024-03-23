package com.edu.java.matrix;

public class TransposeAMatrix {

	public static void main(String... args) {
		int[][] mat = { { 1, 1, 1, 1 }, 
						{ 2, 2, 2, 2 }, 
						{ 3, 3, 3, 3 }, 
						{ 4, 4, 4, 4 } };
		int n = 4;
		
		transpose(mat, n);
		System.out.println(mat);
	}

	private static void transpose(int[][] mat, int n) {
		for (int rowIdx = 0; rowIdx < mat.length; rowIdx++) {
			for (int colIdx = 0; rowIdx > colIdx && colIdx < mat[rowIdx].length; colIdx++) {
				swap(mat, rowIdx, colIdx);
			}
		}
	}

	private static void swap(int[][] mat, int rowIdx, int colIdx) {
		int temp = mat[rowIdx][colIdx];
		mat[rowIdx][colIdx] = mat[colIdx][rowIdx];
		mat[colIdx][rowIdx] = temp;
	}

}
