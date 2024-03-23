package com.edu.lc.test;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LC_733_FloodFill {

	private static final Logger LOGGER = LoggerFactory.getLogger(LC_733_FloodFill.class);

	public static void main(String[] args) {
		int[][] image = { { 1, 1, 1 }, 
						  { 1, 1, 0 }, 
						  { 1, 0, 1 } };
		int sr = 1;
		int sc = 1;
		int color = 2;
		int[][] floodFill = floodFill(image, sr, sc, color);
		for(int[] flood : floodFill) {
			LOGGER.info("{}", Arrays.toString(flood));
		}
	}

	public static int[][] floodFill(int[][] image, int rowIdx, int colIdx, int tgtColor) {
		int[][] graph = clone(image);
		boolean[][] vis = new boolean[image.length][image[0].length];
		int srcColor = graph[rowIdx][colIdx];
		if(vis[rowIdx][colIdx] == false && srcColor != tgtColor) {
			graph[rowIdx][colIdx] = tgtColor;
			dfs(graph, vis, rowIdx, colIdx, srcColor, tgtColor);
		}
		return graph;
	}

	private static void dfs(int[][] graph, boolean[][] vis, int rowIdx, int colIdx, int srcColor, int tgtColor) {
		vis[rowIdx][colIdx] = true;
		int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int[] direction : directions) {
			int newRowIdx = rowIdx + direction[0];
			int newColIdx = colIdx + direction[1];
			if (newRowIdx >= 0 && newColIdx >= 0 && newRowIdx < graph.length && newColIdx < graph[newRowIdx].length
					&& vis[newRowIdx][newColIdx] == false && graph[newRowIdx][newColIdx] == srcColor) {
				graph[newRowIdx][newColIdx] = tgtColor;
				dfs(graph, vis, newRowIdx, newColIdx, srcColor, tgtColor);
			}
		}
	}

	private static int[][] clone(int[][] image) {
		int[][] graph = new int[image.length][image[0].length];
		for (int rowIdx = 0; rowIdx < image.length; rowIdx++) {
			for (int colIdx = 0; colIdx < image[rowIdx].length; colIdx++) {
				graph[rowIdx][colIdx] = image[rowIdx][colIdx];
			}
		}
		return graph;
	}

}
