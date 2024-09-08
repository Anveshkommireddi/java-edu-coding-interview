package com.edu.java.recursion;

public class NQueensCount {

	public static void main(String[] args) {
		int n = 3;
		int result = solveNQueens(n);
		System.out.println(result);
	}

	public static int solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (int rowIdx = 0; rowIdx < n; rowIdx++) {
			for (int colIdx = 0; colIdx < n; colIdx++) {
				board[rowIdx][colIdx] = '.';
			}
		}
		int result = countNQueensHelper(board, n, 0);
		return result;
	}

	private static int countNQueensHelper(char[][] board, int n, int rowIdx) {
		if (rowIdx == n) {
			return 1;
		}
		int result = 0;
		for (int colIdx = 0; colIdx < n; colIdx++) {
			if (isValid(board, rowIdx, colIdx, n)) {
				board[rowIdx][colIdx] = 'Q';
				result += countNQueensHelper(board, n, rowIdx + 1);
				board[rowIdx][colIdx] = '.';
			}
		}
		return result;
	}

	private static boolean isValid(char[][] board, int crowIdx, int ccolIdx, int n) {
		if (crowIdx > n || ccolIdx > n)
			return false;
		if (board[crowIdx][ccolIdx] != '.')
			return false;
		// row has no Q
		for (int colIdx = 0; colIdx < n; colIdx++) {
			if (board[crowIdx][colIdx] == 'Q')
				return false;
		}
		// col has no Q
		for (int rowIdx = 0; rowIdx < n; rowIdx++) {
			if (board[rowIdx][ccolIdx] == 'Q')
				return false;
		}
		// left top diagonal has no Q
		int row = crowIdx;
		int col = ccolIdx;
		while (row >= 0 && col >= 0) {
			if (board[row][col] == 'Q') {
				return false;
			}
			row--;
			col--;
		}

		// left down diagonal has no Q
		row = crowIdx;
		col = ccolIdx;
		while (row < n && col < n) {
			if (board[row][col] == 'Q') {
				return false;
			}
			row++;
			col++;
		}

		// right top diagonal has no Q
		row = crowIdx;
		col = ccolIdx;
		while (row >= 0 && col < n) {
			if (board[row][col] == 'Q') {
				return false;
			}
			row--;
			col++;
		}

		// right down diagonal has no Q
		row = crowIdx;
		col = ccolIdx;
		while (row < n && col >= 0) {
			if (board[row][col] == 'Q') {
				return false;
			}
			row++;
			col--;
		}
		return true;
	}

}
