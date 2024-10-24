package com.edu.java.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {

	public static void main(String[] args) {
		// int[][] times = { { 1, 2, 1 }, { 2, 3, 1 }, { 1, 4, 4 }, { 3, 4, 1 } };
		int[][] times = { { 1, 2, 1 }, { 2, 3, 1 } };
		int n = 3;
		int k = 2;
		int result = networkDelayTime(times, n, k);
		System.out.println(result);
	}

	public static int networkDelayTime(int[][] times, int n, int k) {
		Map<Integer, List<int[]>> adjList = new HashMap<>();
		for (int[] time : times) {
			int from = time[0];
			int to = time[1];
			int timeTaken = time[2];
			List<int[]> neighbors = adjList.getOrDefault(from, new ArrayList<>());
			neighbors.add(new int[] { to, timeTaken });
			adjList.put(from, neighbors);
		}

		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[k] = 0;
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((val1, val2) -> val1[0] - val2[0]);
		minHeap.add(new int[] { 0, k });

		while (!minHeap.isEmpty()) {
			int[] currNode = minHeap.poll();
			int currDist = currNode[0];
			int currFrom = currNode[1];
			List<int[]> neighbors = adjList.getOrDefault(currFrom, new ArrayList<>());
			for (int[] neighbor : neighbors) {
				int nDist = neighbor[1];
				if (currDist + nDist < dist[neighbor[0]]) {
					dist[neighbor[0]] = currDist + nDist;
					minHeap.add(new int[] { dist[neighbor[0]], neighbor[0] });
				}
			}
		}
		int result = -1;
		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				return -1;
			result = Math.max(result, dist[i]);
		}
		return result;
	}

}
