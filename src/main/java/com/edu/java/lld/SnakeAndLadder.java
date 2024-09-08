package com.edu.java.lld;

import java.util.HashMap;
import java.util.Map;

public class SnakeAndLadder {

	private static final int BOARD_SIZE = 100;
	private Map<Integer, Integer> snakes;
	private Map<Integer, Integer> ladders;
	private Map<String, Integer> players;

	public SnakeAndLadder() {
		snakes = new HashMap<>();
		ladders = new HashMap<>();
		players = new HashMap<>();
	}

	public void addSnake(int start, int end) {
		snakes.put(start, end);
	}

	public void addLadder(int start, int end) {
		ladders.put(start, end);
	}

	public void addPlayer(String name) {
		players.put(name, 0);
	}

	public int rollDice() {
		return (int) (Math.random() * 6) + 1;
	}

	public void playTurn(String playerName) {
		int currentPosition = players.get(playerName);
		int diceRoll = rollDice();
		int newPosition = currentPosition + diceRoll;

		if (newPosition > BOARD_SIZE) {
			newPosition = currentPosition;
		} else if (snakes.containsKey(newPosition)) {
			newPosition = snakes.get(newPosition);
		} else if (ladders.containsKey(newPosition)) {
			newPosition = ladders.get(newPosition);
		}

		players.put(playerName, newPosition);
		System.out.println(
				playerName + " rolled a " + diceRoll + ". Moved from " + currentPosition + " to " + newPosition);

		if (newPosition == BOARD_SIZE) {
			System.out.println(playerName + " wins!");
		}
	}

	public static void main(String[] args) {
		SnakeAndLadder game = new SnakeAndLadder();
		game.addSnake(16, 6);
		game.addSnake(47, 26);
		game.addSnake(49, 11);
		game.addSnake(56, 53);
		game.addSnake(62, 19);
		game.addSnake(64, 60);
		game.addSnake(87, 24);
		game.addSnake(93, 73);
		game.addSnake(95, 75);
		game.addLadder(1, 38);
		game.addLadder(4, 14);
		game.addLadder(9, 31);
		game.addLadder(21, 42);
		game.addLadder(28, 84);
		game.addLadder(36, 44);
		game.addLadder(51, 67);
		game.addLadder(71, 91);
		game.addLadder(80, 100);
		game.addPlayer("Player 1");
		game.addPlayer("Player 2");

		while (true) {
			for (String player : game.players.keySet()) {
				game.playTurn(player);
				if (game.players.get(player) == BOARD_SIZE) {
					return;
				}
			}
		}
		
	}
}
