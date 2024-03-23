package com.edu.java.recursion;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SudokoSolver {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SudokoSolver.class);
	
	public static void main(String[] args) {
		int[][] board = {
		                 {7, 8, 0, 4, 0, 0, 1, 2, 0},
		                 {6, 0, 0, 0, 7, 5, 0, 0, 9},
		                 {0, 0, 0, 6, 0, 1, 0, 7, 8},
		                 {0, 0, 7, 0, 4, 0, 2, 6, 0},
		                 {0, 0, 1, 0, 5, 0, 9, 3, 0},
		                 {9, 0, 4, 0, 6, 0, 0, 0, 5},
		                 {0, 7, 0, 3, 0, 0, 0, 1, 2},
		                 {1, 2, 0, 0, 0, 7, 4, 0, 0},
		                 {0, 4, 9, 2, 0, 6, 0, 0, 7}
		};
		printBoard(board);
		solve(board);
		printBoard(board);
	}

	private static boolean solve(int[][] board) {

		boolean isUnSolved = false;
		int row = -1;
		int col = -1;

		outer: for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
			for (int colIdx = 0; colIdx < 9; colIdx++) {
				if (board[rowIdx][colIdx] == 0) {
					isUnSolved = true;
					row = rowIdx;
					col = colIdx;
					break outer;
				}
			}
		}

		if (isUnSolved == false)
			return true;

		for (int val = 1; val <= 9; val++) {
			if (isSafe(board, val, row, col)) {
				board[row][col] = val;
				boolean isSolved = solve(board);
				if (isSolved == true) return true;
				board[row][col] = 0;
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] board, int val, int row, int col) {
		
		boolean isRowSafe = isRowSafe(board, val, row);
		if(isRowSafe == false) return false;
		
		boolean isColSafe = isColumnSafe(board, val, col);
		if(isColSafe == false) return false;
		
		boolean isSquareSafe = isSquareSafe(board, val, row, col);
		if(isSquareSafe == false) return false;
		
		return true;
	}
	
	private static boolean isRowSafe(int[][] board, int val, int row) {
		// row check
		for (int colIdx = 0; colIdx < 9; colIdx++) {
			if (board[row][colIdx] == val) return false;
		}
		return true;
	}
	
	private static boolean isColumnSafe(int[][] board, int val, int col) {
		// column check
		for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
			if (board[rowIdx][col] == val) return false;
		}
		return true;
	}
	
	private static boolean isSquareSafe(int[][] board, int val, int row, int col) {
		int squaredRow = (row / 3) * 3;
		int squaredCol = (col / 3) * 3;
		for(int rowIdx = squaredRow; rowIdx < squaredRow + 3; rowIdx++) {
			for(int colIdx = squaredCol; colIdx < squaredCol + 3; colIdx++) {
				if(board[rowIdx][colIdx] == val) return false;
			}
		}
		return true;
	}

	private static void printBoard(int[][] board) {
		for(int rowIdx = 0; rowIdx < 9; rowIdx++) {
			System.out.println(Arrays.toString(board[rowIdx]));
		}
		System.out.println("===========================");
	}

}
