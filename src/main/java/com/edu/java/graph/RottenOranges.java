package com.edu.java.graph;

import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RottenOranges {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RottenOranges.class);
	
	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, 
						 { 1, 1, 0 }, 
						 { 0, 1, 1 } };
		int timeTaken = rottenOranges(grid);
		LOGGER.info("Time to rot all oranges is {}", timeTaken);
	}

	private static int rottenOranges(int[][] grid) {
		int result = Integer.MIN_VALUE;
		int[][] visited = new int[grid.length][grid[0].length];
		Queue<Pair> queue = new LinkedList<>();
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == 2) {
					visited[row][col] = 2;
					queue.add(new Pair(row, col, 0));
				}
			}
		}

		while (!queue.isEmpty()) {
			Pair node = queue.poll();
			result = Math.max(result, node.time);
			int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
			for (int[] direction : directions) {
				int nRow = node.rowIdx + direction[0];
				int nCol = node.colIdx + direction[1];
				if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] == 1
						&& visited[nRow][nCol] != 2) {
					visited[nRow][nCol] = 2;
					queue.add(new Pair(nRow, nCol, node.time + 1));
				}
			}
		}
		
	   boolean allRotten = checkAllRotten(grid, visited);
		return allRotten ? result : -1;
	}

	private static boolean checkAllRotten(int[][] grid, int[][] visited) {
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == 1 && visited[row][col] != 2)
					return false;
			}
		}
		return true;
	}

}
