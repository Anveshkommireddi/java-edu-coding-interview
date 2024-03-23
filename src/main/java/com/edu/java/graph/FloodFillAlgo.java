package com.edu.java.graph;

import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FloodFillAlgo {

	private static final Logger LOGGER = LoggerFactory.getLogger(FloodFillAlgo.class);

	public static void main(String[] args) {
		int[][] image = { { 1, 1, 1 }, 
						  { 1, 1, 0 }, 
						  { 1, 0, 1 } };
		int sr = 1;
		int sc = 1;
		int color = 2;
		int[][] result = floodFill(image, sr, sc, color);
		LOGGER.info("Result is {}", result);
	}

	private static int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int[][] result = new int[image.length][image[0].length];
		for (int row = 0; row < image.length; row++) {
			for (int col = 0; col < image[0].length; col++) {
				result[row][col] = image[row][col];
			}
		}

		boolean[][] visited = new boolean[image.length][image[0].length];
		if (visited[sr][sc] == false) {
			dfs(result, visited, sr, sc, result[sr][sc], color);
		}
		return result;
	}

	private static void dfs(int[][] result, boolean[][] visited, int srcRow, int srcCol, int srcColor,
			int targetColor) {
		visited[srcRow][srcCol] = true;
		result[srcRow][srcCol] = targetColor;

		int[][] directions = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		for (int[] direction : directions) {
			int nRow = srcRow + direction[0];
			int nCol = srcCol + direction[1];
			if (nRow >= 0 && nRow < result.length && nCol >= 0 && nCol < result[0].length
					&& result[nRow][nCol] == srcColor && visited[nRow][nCol] == false) {
				dfs(result, visited, nRow, nCol, srcColor, targetColor);
			}
		}
	}

	private static void bfs(int[][] result, boolean[][] visited, int srcRow, int srcCol, int srcColor,
			int targetColor) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(srcRow, srcCol));
		visited[srcRow][srcCol] = true;
		result[srcRow][srcCol] = targetColor;

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			int rowIdx = pair.rowIdx;
			int colIdx = pair.colIdx;
			int[][] directions = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
			for (int[] direction : directions) {
				int nRow = rowIdx + direction[0];
				int nCol = colIdx + direction[1];
				if (nRow >= 0 && nRow < result.length && nCol >= 0 && nCol < result[0].length
						&& result[nRow][nCol] == srcColor && visited[nRow][nCol] == false) {
					visited[nRow][nCol] = true;
					result[nRow][nCol] = targetColor;
					queue.add(new Pair(nRow, nCol));
				}
			}
		}
	}

}


