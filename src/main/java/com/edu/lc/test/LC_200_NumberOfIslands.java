package com.edu.lc.test;

import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.edu.java.graph.Pair;

public class LC_200_NumberOfIslands {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LC_200_NumberOfIslands.class);
	
	public static void main(String[] args) {
	 String[][] graph = 	{
			 					{"1","1","0","0","0"},
			 					{"1","1","0","0","0"},
			 					{"0","0","1","0","0"},
			 					{"0","0","0","1","1"}
	 						};
	 int numOfIslands = countNumberOfIslands(graph);
	 LOGGER.info("Number of Islands are {}", numOfIslands);
	}

	private static int countNumberOfIslands(String[][] graph) {
		int rowsCount = graph.length;
		int colsCount = graph[0].length;
		boolean[][] vis = new boolean[rowsCount][colsCount];
		int result = 0;
		for(int rowIdx = 0; rowIdx < rowsCount; rowIdx++) {
			for(int colIdx = 0; colIdx < colsCount; colIdx++) {
				if(vis[rowIdx][colIdx] == false &&  "1".equalsIgnoreCase(graph[rowIdx][colIdx])) {
					bfs(graph, vis, rowIdx, colIdx);
					result++;
				}
			}
		}
		return result;
	}

	private static void bfs(String[][] graph, boolean[][] vis, int rowIdx, int colIdx) {

		vis[rowIdx][colIdx] = true;

		int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(rowIdx, colIdx));
		while (!queue.isEmpty()) {
			Pair currPair = queue.poll();
			for (int[] direction : directions) {
				int newRowIdx = currPair.rowIdx + direction[0];
				int newColIdx = currPair.colIdx + direction[1];
				if (newRowIdx >= 0 && newColIdx >= 0 && newRowIdx < graph.length && newColIdx < graph[newRowIdx].length
						&& vis[newRowIdx][newColIdx] == false && "1".equalsIgnoreCase(graph[newRowIdx][newColIdx])) {
					vis[newRowIdx][newColIdx] = true;
					queue.add(new Pair(newRowIdx, newColIdx));
				}
			}
		}

	}

}
