package com.edu.java.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WordSearch {

	private static final Logger LOGGER = LoggerFactory.getLogger(WordSearch.class);

	public static void main(String[] args) {
		String[][] board = { { "A", "B", "C", "E" }, { "S", "F", "C", "S" }, { "A", "D", "E", "E" } };
		String word = "ABCCED";
		boolean isExist = wordSearch(board, word);
		LOGGER.info("Word Exists :: {}", isExist);
	}

	private static boolean wordSearch(String[][] board, String word) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		int startRow = 0;
		int startCol = 0;
		return wordSearchHelper(board, word, visited, startRow, startCol);
	}

	private static boolean wordSearchHelper(String[][] board, String word, boolean[][] visited, int startRow, int startCol) {
		int nRow = board.length;
		int nCol = board[0].length;
		for (int row = startRow; row < nRow; row++) {
			for (int col = startCol; col < nCol; col++) {
				if (board[row][col].equals(String.valueOf(word.charAt(0)))) {
					boolean isMatch = findMatch(board, word, visited, row, col, nRow, nCol, 0);
					if (isMatch)
						return true;
				}
			}
		}
		return false;
	}

	private static boolean findMatch(String[][] board, String word, boolean[][] visited, int row, int col, int nRow,
			int nCol, int level) {
		int length = word.length();

		if (level == length)
			return true;

		if (row < 0 || row >= nRow || col < 0 || col >= nCol)
			return false;

		if (board[row][col].equals(String.valueOf(word.charAt(level))) && visited[row][col] == false) {
			visited[row][col] = true;
			boolean left = findMatch(board, word, visited, row, col - 1, nRow, nCol, level + 1);
			boolean right = findMatch(board, word, visited, row, col + 1, nRow, nCol, level + 1);
			boolean top = findMatch(board, word, visited, row + 1, col, nRow, nCol, level + 1);
			boolean bottom = findMatch(board, word, visited, row - 1, col, nRow, nCol, level + 1);
			visited[row][col] = false;
			return left || right || top || bottom;
		}
		return false;
	}

}
