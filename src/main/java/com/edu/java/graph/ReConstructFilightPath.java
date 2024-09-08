package com.edu.java.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class ReConstructFilightPath {

	public static void main(String[] args) {
		List<List<String>> tickets = Arrays.asList(Arrays.asList("HOU","JFK"), Arrays.asList("SEA","JFK"),
				Arrays.asList("JFK","SEA"), Arrays.asList("JFK","HOU"));
		List<String> result = findItinerary(tickets);
		System.out.println(result);
	}

	public static List<String> findItinerary(List<List<String>> tickets) {
		Map<String, Integer> locationIdxMap = new TreeMap<>();
		int idx = 0;
		for (List<String> ticket : tickets) {

			String src = ticket.get(0);
			if (!locationIdxMap.containsKey(src)) {
				locationIdxMap.put(src, idx);
				idx++;
			}

			String dest = ticket.get(1);
			if (!locationIdxMap.containsKey(dest)) {
				locationIdxMap.put(dest, idx);
				idx++;
			}
		}
		Map<Integer, String> idxLocationMap = new HashMap<>();
		locationIdxMap.entrySet().stream().forEach(entry -> {
			idxLocationMap.put(entry.getValue(), entry.getKey());
		});
		int[] indegree = new int[locationIdxMap.size()];
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < locationIdxMap.size(); i++) {
			adjList.add(new ArrayList<>());
		}
		for (List<String> ticket : tickets) {
			String src = ticket.get(0);
			String dest = ticket.get(1);
			int srcIdx = locationIdxMap.get(src);
			int destIdx = locationIdxMap.get(dest);
			adjList.get(srcIdx).add(destIdx);
			indegree[destIdx]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		List<Integer> topo = new ArrayList<>();
		while (!queue.isEmpty()) {
			Integer currIdx = queue.poll();
			topo.add(currIdx);
			List<Integer> neighbours = adjList.get(currIdx);
			for (Integer neighbour : neighbours) {
				indegree[neighbour]--;
				if (indegree[neighbour] == 0) {
					queue.add(neighbour);
				}
			}
		}
		
		List<String> result = new ArrayList<>();
		for(Integer topoIdx : topo) {
			result.add(idxLocationMap.get(topoIdx));
		}
		return result;
	}

}
