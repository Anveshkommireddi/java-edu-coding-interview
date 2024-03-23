package com.edu.java.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BiPartiteGraph {

	private static final int YELLOW = 6;
	private static final int GREEN = 9;
	private static final int WHITE = 0;

	public static void main(String[] args) {
		int[][] mat = { 
				{ 0, 1, 0, 1 }, 
				{ 1, 0, 1, 0 }, 
				{ 0, 1, 0, 1 }, 
				{ 1, 0, 1, 0 } };
		Graph graph = new Graph(4, true);
		for (int x = 0; x < mat.length; x++) {
			for (int y = 0; y < mat[x].length; y++)
				if (mat[x][y] == 1)
					graph.addEdge(x, y);
		}
		boolean isBipartie = checkIfGraphisBipartedDFS(graph.adjLst);
		System.out.print(isBipartie);
	}
	
	private static boolean checkIfGraphisBipartedDFS(List<List<Integer>> adjLst) {
		int[] color = new int[adjLst.size()];
		for (int vertex = 0; vertex < adjLst.size(); vertex++) {
			if (color[vertex] == WHITE) {
				boolean isValid = dfs(adjLst, color, vertex, YELLOW);
				if (!isValid)
					return isValid;
			}
		}
		return true;
	}

	private static boolean dfs(List<List<Integer>> adjLst, int[] color, int srcVertex, int srcColor) {
		color[srcVertex] = srcColor;
		List<Integer> connectedVertices = adjLst.get(srcVertex);
		for (int connectedVertex : connectedVertices) {
			if (color[connectedVertex] == srcColor)
				return false;
			if (color[connectedVertex] == WHITE) {
				int newColor = srcColor == YELLOW ? GREEN : YELLOW;
				boolean valid = dfs(adjLst, color, connectedVertex, newColor);
				if (!valid)
					return valid;
			}
		}
		return true;
	}

	private static boolean checkIfGrapthisBiParted(List<List<Integer>> adjLst) {
		int[] color = new int[adjLst.size()];
		for (int vertex = 0; vertex < adjLst.size(); vertex++) {
			if (color[vertex] == WHITE) {
				boolean result = bfs(adjLst, color, vertex);
				if (!result)
					return result;
			}
		}
		return true;
	}

	private static boolean bfs(List<List<Integer>> adjLst, int[] color, int srcVertex) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(srcVertex);
		color[srcVertex] = YELLOW;

		while (!queue.isEmpty()) {
			Integer currVertex = queue.poll();
			for (Integer connectedVertex : adjLst.get(currVertex)) {
				if (color[connectedVertex] == color[currVertex])
					return false;
				if (color[currVertex] == WHITE) {
					color[connectedVertex] = color[currVertex] == YELLOW ? GREEN : YELLOW;
					queue.add(connectedVertex);
				}
			}
		}
		return true;
	}
}
