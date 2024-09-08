package com.edu.java.backtracking;

public class WordSearch {

	public static void main(String... args) {
		char[][] board = { { 'J', 'D', 'E', 'I', 'Y' }, 
				           { 'G', 'I', 'L', 'M', 'O' }, 
				           { 'Z', 'A', 'I', 'E', 'O' },
				           { 'L', 'T', 'B', 'S', 'N' }, 
				           { 'S', 'I', 'T', 'C', 'C' } };
		String word = "MOON";
		boolean exists = searchWord(board, word);
		System.out.println(exists);
	}

	private static boolean searchWord(char[][] board, String word) {
		return searchWordHelper(board, word);
	}

	private static boolean searchWordHelper(char[][] board, String word) {
		for (int rowIdx = 0; rowIdx < board.length; rowIdx++) {
			for (int colIdx = 0; colIdx < board[rowIdx].length; colIdx++) {
				if (board[rowIdx][colIdx] == word.charAt(0)) {
					boolean fullMatch = wordSearch(board, word, rowIdx, colIdx, 0);
					if (fullMatch == true)
						return true;
				}
			}
		}
		return false;
	}

	private static boolean wordSearch(char[][] board, String word, int rowIdx, int colIdx, int wordIdx) {
		if (rowIdx >= board.length || colIdx >= board[0].length || wordIdx >= word.length())
			return false;
		if (board[rowIdx][colIdx] != word.charAt(wordIdx))
			return false;
		return false;
	}

}
