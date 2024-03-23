package com.edu.java.recursion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NQueens {

	private static final Logger LOGGER = LoggerFactory.getLogger(NQueens.class);

	public static void main(String[] args) {
		int sizeOfTheBoard = 4;
		char[][] board = new char[sizeOfTheBoard][sizeOfTheBoard];
		for (int rowIdx = 0; rowIdx < sizeOfTheBoard; rowIdx++)
			for (int colIdx = 0; colIdx < sizeOfTheBoard; colIdx++)
				board[rowIdx][colIdx] = '.';
		List<List<String>> result = new ArrayList<>();
		solve(board, 0, sizeOfTheBoard, result);
		LOGGER.info("Result :: {}", result);
	}

	private static void solve(char[][] board, int colIdx, int sizeOfTheBoard, List<List<String>> result) {

		if (colIdx == sizeOfTheBoard) {
			result.add(constructBoard(board));
			return;
		}

		for (int rowIdx = 0; rowIdx < sizeOfTheBoard; rowIdx++) {
			if (board[rowIdx][colIdx] == '.' && validate(board, rowIdx, colIdx)) {
				board[rowIdx][colIdx] = 'Q';
				solve(board, colIdx + 1, sizeOfTheBoard, result);
				board[rowIdx][colIdx] = '.';
			}
		}
	}

	private static List<String> constructBoard(char[][] board) {
		List<String> currBoard = new ArrayList<>();
		for (int rowIdx = 0; rowIdx < board.length; rowIdx++) {
			currBoard.add(new String(board[rowIdx]));
		}
		return currBoard;
	}

	private static boolean validate(char[][] board, int rowIdx, int colIdx) {
		int row = rowIdx;
		int col = colIdx;

		while (rowIdx >= 0 && colIdx >= 0) {
			if (board[rowIdx][colIdx] == 'Q')
				return false;
			rowIdx--;
			colIdx--;
		}

		rowIdx = row;
		colIdx = col;
		while (colIdx >= 0) {
			if (board[rowIdx][colIdx] == 'Q')
				return false;
			colIdx--;
		}

		rowIdx = row;
		colIdx = col;
		while (colIdx >= 0 && rowIdx < board.length) {
			if (board[rowIdx][colIdx] == 'Q')
				return false;
			rowIdx++;
			colIdx--;
		}
		return true;
	}
}
