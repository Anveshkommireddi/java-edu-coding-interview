package com.edu.java.recursion;

public class WordSearchTest {

	public static void main(String[] args) {
		char[][] grid = {
					{'D', 'O', 'C', 'A', 'L'},
					{'O', 'J', 'N', 'L', 'Z'},
					{'T', 'Z', 'Y', 'L' ,'K'},
					{'G', 'Y', 'R', 'O', 'U'},
					{'F', 'K', 'M', 'W', 'D'}};
		String word = "CALLOUS";
		boolean wordPresent = searchHelper(grid, word);
		System.out.println(wordPresent);
	}

	private static boolean searchHelper(char[][] grid, String word) {
		int trows = grid.length;
		int tcols = grid[0].length;
		boolean[][] vis = new boolean[trows][tcols];
		for(int rowIdx = 0; rowIdx < trows; rowIdx++) {
			for(int colIdx = 0; colIdx < tcols; colIdx++) {
				if(grid[rowIdx][colIdx] == word.charAt(0)) {
					if(dfs(grid, word, rowIdx, colIdx, vis, trows, tcols, 1)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean dfs(char[][] grid, String word, int rowIdx, int colIdx, boolean[][] vis, int trows,
			int tcols, int wordIdx) {
		if (wordIdx == word.length()) {
			return true;
		}
		vis[rowIdx][colIdx] = true;
		int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		for (int[] direction : directions) {
			int newRowIdx = rowIdx + direction[0];
			int newColIdx = colIdx + direction[1];
//			boolean isValidRowsUp = newRowIdx < trows;
//			boolean isValidColsUp = newColIdx < tcols;
//			boolean isValidRowsLow = newRowIdx >= 0;
//			boolean isValidColsLow = newColIdx >= 0; 
			if (newRowIdx < trows && newColIdx < tcols && newRowIdx >= 0 && newColIdx >= 0
					&& vis[newRowIdx][newColIdx] == false && word.charAt(wordIdx) == grid[newRowIdx][newColIdx]) {
				if(dfs(grid, word, newRowIdx, newColIdx, vis, trows, tcols, wordIdx + 1)) {
					return true;
				}
			}
		}
		vis[rowIdx][colIdx] = false;
		return false;
	}

}
