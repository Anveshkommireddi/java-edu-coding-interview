package com.edu.java.dp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//count total unique paths from top left corner to down right corner
// we can move to down and right only
public class DP_08_GridUniquePaths1 {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DP_08_GridUniquePaths1.class);
	
	public static void main(String[] args) {
		int m = 3;
		int n = 2;
		int totalUniquePaths = totalUniquePaths(m-1, n-1);
		LOGGER.info("Total Unique Paths :: {}", totalUniquePaths);
		Integer[][] mem = new Integer[m][n];
		int totalUniquePathsMem = totalUniquePathsMem(m-1, n-1, mem);
		LOGGER.info("Total Unique Paths using Mem :: {}", totalUniquePathsMem);
		int totalUniquePathsLoop = totalUniquePathLoop(m, n);
		LOGGER.info("Total Unique Paths using loop :: {}", totalUniquePathsLoop);
	}
	
	private static int totalUniquePathLoop(int m, int n) {
		Integer[][] mem = new Integer[m][n];
		for (int rowIdx = 0; rowIdx < m; rowIdx++) {
			for (int colIdx = 0; colIdx < n; colIdx++) {
				if (rowIdx == 0 && colIdx == 0) {
					mem[rowIdx][colIdx] = 1;
					continue;
				}
				int upPath = rowIdx >= 1 ? mem[rowIdx - 1][colIdx] : 0;
				int leftPath = colIdx >= 1 ? mem[rowIdx][colIdx - 1] : 0;
				mem[rowIdx][colIdx] = upPath + leftPath;
			}
		}
		return mem[m - 1][n - 1];
	}
	
	private static int totalUniquePathsMem(int rowIdx, int colIdx, Integer[][] mem) {
		if (rowIdx == 0 && colIdx == 0) return 1;
		if (rowIdx < 0 || colIdx < 0) return 0;
		if(null != mem[rowIdx][colIdx]) return mem[rowIdx][colIdx];
		int upPath = totalUniquePathsMem(rowIdx - 1, colIdx, mem);
		int leftPath = totalUniquePathsMem(rowIdx, colIdx - 1, mem);
		return mem[rowIdx][colIdx] = upPath + leftPath;
	}

	private static int totalUniquePaths(int rowIdx, int colIdx) {
		if (rowIdx == 0 && colIdx == 0) return 1;
		if (rowIdx < 0 || colIdx < 0) return 0;
		int upPath = totalUniquePaths(rowIdx - 1, colIdx);
		int leftPath = totalUniquePaths(rowIdx, colIdx - 1);
		return upPath + leftPath;
	}

}
