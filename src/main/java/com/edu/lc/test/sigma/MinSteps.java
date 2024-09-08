package com.edu.lc.test.sigma;

import java.util.List;

public class MinSteps {

	public static int getMinimumMoves(List<List<Integer>> maze, int k) {
		int n = maze.size() - 1;
		int m = maze.get(n).size() - 1;
		maze.get(0).set(0, 2);
		Integer[][] mem = new Integer[n + 1][m + 1];
		int res = mmHelper(maze, k, 0, 0, n, m, mem);
		maze.get(0).set(0, 0);
		return res == 1000000009 || res < 0 ? -1 : res;
	}

	private static int mmHelper(List<List<Integer>> maze, int k, int rowIdx, int colIdx, int maxRowIdx, int maxColIdx,
			Integer[][] mem) {
		if (rowIdx == maxRowIdx && colIdx == maxColIdx)
			return 0;
		if (null != mem[rowIdx][colIdx])
			return mem[rowIdx][colIdx];
		int minVal = 1000000009;
		// i+x, j
		for (int i = 1; i <= k; i++) {
			int newRowIdx = rowIdx + i;
			int newColIdx = colIdx;
			if (validate(maze, newRowIdx, newColIdx)) {
				// System.out.println("newRow newCol Val " +
				// maze.get(newRowIdx).get(newColIdx));
				if (maze.get(newRowIdx).get(newColIdx) == 1) {
					break;
				}
				if (maze.get(newRowIdx).get(newColIdx) == 0) {
					maze.get(newRowIdx).set(newColIdx, 2);
					int prowVal = 1 + mmHelper(maze, k, newRowIdx, newColIdx, maxRowIdx, maxColIdx, mem);
					maze.get(newRowIdx).set(newColIdx, 0);
					minVal = Math.min(minVal, prowVal);
				}
			}
		}
		// i, j+x
		for (int i = 1; i <= k; i++) {
			int newRowIdx = rowIdx;
			int newColIdx = colIdx + i;
			if (validate(maze, newRowIdx, newColIdx)) {
				if (maze.get(newRowIdx).get(newColIdx) == 1) {
					break;
				}
				if (maze.get(newRowIdx).get(newColIdx) == 0) {
					maze.get(newRowIdx).set(newColIdx, 2);
					int pcolVal = 1 + mmHelper(maze, k, newRowIdx, newColIdx, maxRowIdx, maxColIdx, mem);
					maze.get(newRowIdx).set(newColIdx, 0);
					minVal = Math.min(minVal, pcolVal);

				}
			}
		}
		// i-x, j
		for (int i = 1; i <= k; i++) {
			int newRowIdx = rowIdx - i;
			int newColIdx = colIdx;
			if (validate(maze, newRowIdx, newColIdx)) {
				if (maze.get(newRowIdx).get(newColIdx) == 1) {
					break;
				}
				if (maze.get(newRowIdx).get(newColIdx) == 0) {
					maze.get(newRowIdx).set(newColIdx, 2);
					int nrowVal = 1 + mmHelper(maze, k, newRowIdx, newColIdx, maxRowIdx, maxColIdx, mem);
					maze.get(newRowIdx).set(newColIdx, 0);
					minVal = Math.min(minVal, nrowVal);
				}
			}
		}
		// i, j-x
		for (int i = 1; i <= k; i++) {
			int newRowIdx = rowIdx;
			int newColIdx = colIdx - i;
			if (validate(maze, newRowIdx, newColIdx)) {
				if (maze.get(newRowIdx).get(newColIdx) == 1) {
					break;
				}
				if (maze.get(newRowIdx).get(newColIdx) == 0) {
					maze.get(newRowIdx).set(newColIdx, 2);
					int ncolVal = 1 + mmHelper(maze, k, newRowIdx, newColIdx, maxRowIdx, maxColIdx, mem);
					maze.get(newRowIdx).set(newColIdx, 0);
					minVal = Math.min(minVal, ncolVal);
				}
			}
		}
		return mem[rowIdx][colIdx] = minVal;
	}

	private static boolean validate(List<List<Integer>> maze, int rowIdx, int colIdx) {
		int maxRowIdx = maze.size() - 1;
		int maxColIdx = maze.get(0).size() - 1;
		if (rowIdx >= 0 && colIdx >= 0 && rowIdx <= maxRowIdx && colIdx <= maxColIdx) {
			return true;
		}
		return false;
	}

}
