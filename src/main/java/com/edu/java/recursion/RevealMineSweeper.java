package com.edu.java.recursion;

public class RevealMineSweeper {
	
	public static void main(String[] args) {
	    String[][] board =
	            new String[][] {
	          {"H", "H", "H", "H", "M"},
	          {"H", "H", "M", "H", "H"},
	          {"H", "H", "H", "H", "H"},
	          {"H", "H", "H", "H", "H"}
	            };
	        int row = 3;
	        int column = 4;
		    printBoard(board);
		    solve(board, row, column);
		    printBoard(board);
	}

	private static void solve(String[][] board, int row, int col) {

		if (row >= board.length || col >= board[0].length || col < 0 || row < 0)
			return;

		String currVal = board[row][col];
		
		if (currVal.equals("M")) {
			board[row][col] = "X";
			return;
		}
		
		if(!currVal.equals("H")) return;

		int count = getAdjacentMines(board, row, col);
		board[row][col] = String.valueOf(count);
		if (count == 0) {
			for (int rowIdx = -1; rowIdx <= 1; rowIdx++) {
				for (int colIdx = -1; colIdx <= 1; colIdx++) {
					int nrowIdx = row + rowIdx;
					int ncolIdx = col + colIdx;
					if (nrowIdx >= 0 && nrowIdx < board.length && ncolIdx >= 0 && ncolIdx < board[nrowIdx].length) {
						if(board[nrowIdx][ncolIdx].equals("H")) {
							solve(board, nrowIdx, ncolIdx);
						}
					}
				}
			}
		} 

	}

	private static int getAdjacentMines(String[][] board, int row, int col) {
		int result = 0;
		for (int rowIdx = -1; rowIdx <= 1; rowIdx++) {
			for (int colIdx = -1; colIdx <= 1; colIdx++) {
				int nrowIdx = row + rowIdx;
				int ncolIdx = col + colIdx;
				if (nrowIdx >= 0 && nrowIdx < board.length && ncolIdx >= 0 && ncolIdx < board[nrowIdx].length) {
					String currVal = board[nrowIdx][ncolIdx];
					if(currVal.equals("M")) {
						result++;
					}
				}
			}
		}
		return result;
	}

	private static void printBoard(String[][] board) {
		System.out.println("=========");
		for (int rowIdx = 0; rowIdx < board.length; rowIdx++) {
			StringBuilder sb = new StringBuilder();
			for (int colIdx = 0; colIdx < board[rowIdx].length; colIdx++) {
				sb.append(board[rowIdx][colIdx]).append(" ");
			}
			System.out.println(sb.toString());
		}
		System.out.println("=========");
	}

}
