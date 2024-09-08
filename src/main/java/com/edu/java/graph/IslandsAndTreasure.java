package com.edu.java.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IslandsAndTreasure {

	private static final int LAND = 2147483647;
	private static final int TREASURE = 0;
	private static final int WATER = -1;
	
	public static void main(String... args) {
	int[][] grid = 	{
		  {2147483647,-1,0,2147483647},
		  {2147483647,2147483647,2147483647,-1},
		  {2147483647,-1,2147483647,-1},
		  {0,-1,2147483647,2147483647}
		};
		int[][] result = islandsAndTreasure(grid);
		grid = result;
		System.out.println(grid);
	}

	public static int[][] islandsAndTreasure(int[][] grid) {
		int[][] result = clone(grid);
		Queue<int[]> queue = new LinkedList<>();
		for (int rowIdx = 0; rowIdx < grid.length; rowIdx++) {
			for (int colIdx = 0; colIdx < grid[rowIdx].length; colIdx++) {
				if (grid[rowIdx][colIdx] == TREASURE) {
					result[rowIdx][colIdx] = 0;
					queue.add(new int[] { rowIdx, colIdx, 0 });
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] currCell = queue.poll();
			int crowIdx = currCell[0];
			int ccolIdx = currCell[1];
			int clevel = currCell[2];
			int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
			for (int[] direction : directions) {
				int newX = crowIdx + direction[0];
				int newY = ccolIdx + direction[1];
				if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[newX].length && grid[newX][newY] == LAND
						&& result[newX][newY] == -1) {
					result[newX][newY] = 1 + clevel;
					queue.add(new int[] { newX, newY, result[newX][newY] });
				}
			}
		}
		
		return result;
	}

	private static int[][] clone(int[][] grid) {
		int rows = grid.length;
		int[][] graph = new int[rows][];
		for (int rowIdx = 0; rowIdx < rows; rowIdx++) {
			graph[rowIdx] = new int[grid[rowIdx].length];
			Arrays.fill(graph[rowIdx], -1);
		}
		return graph;
	}
}
