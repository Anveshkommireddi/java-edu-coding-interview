package com.edu.java.graph;

import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectedComponents {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConnectedComponents.class);
	
	public static void main(String[] args) {
		char[][] graph = {
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}
		};
		int components = getComponents(graph);
		LOGGER.info("All Components are {}", components);
	}

	private static int getComponents(char[][] graph) {
		int components = 0;
		int rows = graph.length;
		int cols = graph[0].length;
		boolean[][] visited = new boolean[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (visited[row][col] == false && graph[row][col] == '1') {
					bfs(graph, visited, row, col);
					components++;
				}
			}
		}
		return components;
	}

	private static void bfs(char[][] graph, boolean[][] visited, int srcRow, int srcCol) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(srcRow, srcCol));
		visited[srcRow][srcCol] = true;
		int rows = graph.length;
		int cols = graph[0].length;
		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			int row = pair.rowIdx;
			int col = pair.colIdx;
			int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
			for (int[] direction : directions) {
				int nRow = row + direction[0];
				int nCol = col + direction[1];
				if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && graph[nRow][nCol] == '1'
						&& visited[nRow][nCol] == false) {
					visited[nRow][nCol] = true;
					Pair newPair = new Pair(nRow, nCol);
					queue.add(newPair);
				}
			}
		}
	}

}