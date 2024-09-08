package com.edu.java.topological.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CourseSchedule2 {

	private static final Logger LOGGER = LoggerFactory.getLogger(CourseSchedule2.class);

	public static void main(String[] args) {
		//int[][] prerequisites = { { 1, 0 }, { 0, 3 }, { 0, 2 }, { 3, 2 }, { 2, 5 }, { 4, 5 }, { 5, 6 }, { 2, 4 } };
		int[][] prerequisites = { { 1, 0 }, {2, 0}, {3, 1} };
		int n = 5;
		List<Integer> order = findOrder(n, prerequisites);
		LOGGER.info("Order is {}", order);
	}

	public static List<Integer> findOrder(int n, int[][] prerequisites) {
		List<Integer> topo = new ArrayList<>();
		List<List<Integer>> adjList = new ArrayList<>();
		int[] indegree = new int[n];
		for (int vertex = 0; vertex < n; vertex++) {
			adjList.add(new ArrayList<>());
		}
		for (int[] prerequisite : prerequisites) {
			int fromVertex = prerequisite[1];
			int toVertex = prerequisite[0];
			adjList.get(fromVertex).add(toVertex);
			indegree[toVertex]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int vertex = 0; vertex < indegree.length; vertex++) {
			if (indegree[vertex] == 0) {
				queue.add(vertex);
			}
		}
		while (!queue.isEmpty()) {
			int currVertex = queue.poll();
			topo.add(currVertex);
			List<Integer> neighbours = adjList.get(currVertex);
			for (int neighbour : neighbours) {
				indegree[neighbour]--;
				if (indegree[neighbour] == 0) {
					queue.add(neighbour);
				}
			}
		}
		return topo.size() == n ? topo : new ArrayList<>();
	}

}
