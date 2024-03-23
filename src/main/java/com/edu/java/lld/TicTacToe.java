package com.edu.java.lld;

public class TicTacToe {

	private char[][] board;
	private char currentPlayer;

	public TicTacToe() {
		board = new char[3][3];
		currentPlayer = 'X';
		initializeBoard();
	}

	private void initializeBoard() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				board[row][col] = '-';
			}
		}
	}

	public boolean makeMove(int row, int col) {
		if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '-') {
			return false; // Invalid move
		}

		board[row][col] = currentPlayer;
		currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
		return true;
	}

	public boolean checkWin() {
		// Check rows
		for (int row = 0; row < 3; row++) {
			if (board[row][0] != '-' && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
				return true;
			}
		}

		// Check columns
		for (int col = 0; col < 3; col++) {
			if (board[0][col] != '-' && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
				return true;
			}
		}

		// Check diagonals
		if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return true;
		}
		if (board[2][0] != '-' && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
			return true;
		}

		return false;
	}

	public boolean checkDraw() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row][col] == '-') {
					return false; // Empty cell, game not drawn yet
				}
			}
		}
		return true; // All cells are filled, game drawn
	}

	public void printBoard() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				System.out.print(board[row][col] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();

		// Sample game play
		game.makeMove(0, 0);
		game.makeMove(1, 1);
		game.makeMove(0, 1);
		game.makeMove(1, 2);
		game.makeMove(0, 2);
		game.printBoard();

		if (game.checkWin()) {
			System.out.println("Player " + game.currentPlayer + " wins!");
		} else if (game.checkDraw()) {
			System.out.println("Game drawn!");
		} else {
			System.out.println("Game in progress.");
		}
	}
}
