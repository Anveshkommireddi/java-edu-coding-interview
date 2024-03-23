package com.edu.java.recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
	
	public static void main(String[] args) {
		int[][] maze = {
				{1, 0, 0, 0},
				{1, 1, 0, 1},
				{1, 1, 0, 0},
				{0, 1, 1, 1}
		};
		List<String> currSet = new ArrayList<>();
		List<List<String>> result = new ArrayList<>();
		int size = 4;
		solve(maze, 0, 0, size, size, currSet, result);
		System.out.println(result);
	}

	private static void solve(int[][] maze, int rowIdx, int colIdx, int rowSize, int colSize, List<String> currSet,
			List<List<String>> result) {
		
		if (rowIdx == rowSize - 1 && colIdx == colSize - 1) {
			result.add(new ArrayList<>(currSet));
			return;
		}
		
		if(rowIdx > rowSize || colIdx > colSize)
			return;
		maze[rowIdx][colIdx] = 2;
		int[][] coordinates = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int[] coordinate : coordinates) {
			int newX = rowIdx + coordinate[0];
			int newY = colIdx + coordinate[1];
			if (newX >= 0 && newY >= 0 && newX < rowSize && newY < colSize && maze[newX][newY] == 1) {
				String direction = getDirection(coordinate[0], coordinate[1]);
				currSet.add(direction);
				solve(maze, newX, newY, rowSize, colSize, currSet, result);
				currSet.remove(currSet.size() - 1);
			}
		}
		maze[rowIdx][colIdx] = 1;

	}

	private static String getDirection(int x, int y) {
		if (x == 0 && y == 1)
			return "R";
		if (x == 0 && y == -1)
			return "L";
		if (x == 1 && y == 0)
			return "D";
		if (x == -1 && y == 0)
			return "U";
		return "";
	}

}
