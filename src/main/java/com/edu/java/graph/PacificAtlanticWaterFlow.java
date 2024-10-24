package com.edu.java.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		List<List<Integer>> pacAtlantic = pacificAtlantic(heights);
		System.out.println(pacAtlantic);
	}

	private static List<List<Integer>> pacificAtlantic(int[][] heights) {
		int rows = heights.length;
		int cols = heights[0].length;
		boolean[][] pacific = getPacificFlow(heights, rows, cols);
		boolean[][] atlantic = getAtlanticFlow(heights, rows, cols);
		List<List<Integer>> result = pacificAtlanticFlow(pacific, atlantic);
		return result;
	}

	private static void bfs(int[][] heights, boolean[][] vis, int rowIdx, int colIdx) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { rowIdx, colIdx });
		vis[rowIdx][colIdx] = true;
		while (!queue.isEmpty()) {
			int[] currNode = queue.poll();
			int currRowIdx = currNode[0];
			int currColIdx = currNode[1];

			int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
			for (int[] direction : directions) {
				int newRowIdx = direction[0] + currRowIdx;
				int newColIdx = direction[1] + currColIdx;
				if (newRowIdx >= 0 && newColIdx >= 0 && newRowIdx < heights.length
						&& newColIdx < heights[newRowIdx].length && vis[newRowIdx][newColIdx] == false
						&& heights[newRowIdx][newColIdx] <= heights[rowIdx][colIdx]) {
					vis[newRowIdx][newColIdx] = true;
					queue.add(new int[] { newRowIdx, newColIdx });
				}
			}
		}
	}

	private static List<List<Integer>> pacificAtlanticFlow(boolean[][] pacific, boolean[][] atlantic) {
		List<List<Integer>> commonRows = new ArrayList<>();
		return null;
	}

	private static boolean[][] getAtlanticFlow(int[][] heights, int rows, int cols) {
		boolean[][] vis = new boolean[rows][cols];
		// row
		for (int colIdx = 0; colIdx < cols; colIdx++) {
			if (vis[rows - 1][colIdx] == false) {
				bfs(heights, vis, 0, colIdx);
			}
		}
		/// col 0
		for (int rowIdx = 0; rowIdx < rows; rowIdx++) {
			if (vis[rowIdx][cols - 1] == false) {
				bfs(heights, vis, rowIdx, 0);
			}
		}
		return vis;
	}

	private static boolean[][] getPacificFlow(int[][] heights, int rows, int cols) {
		boolean[][] vis = new boolean[rows][cols];
		// row 0
		for (int colIdx = 0; colIdx < cols; colIdx++) {
			if (vis[0][colIdx] == false) {
				bfs(heights, vis, 0, colIdx);
			}
		}
		/// col 0
		for (int rowIdx = 0; rowIdx < rows; rowIdx++) {
			if (vis[rowIdx][0] == false) {
				bfs(heights, vis, rowIdx, 0);
			}
		}
		return vis;
	}
}
