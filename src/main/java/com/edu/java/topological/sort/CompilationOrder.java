package com.edu.java.topological.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class CompilationOrder {

	public static void main(String[] args) {
		char[][] dependencies = { { 'B', 'A' }, { 'C', 'A' }, { 'D', 'C' }, { 'E', 'D' }, { 'E', 'B' } };
		ArrayList<ArrayList<Character>> dependenciesList = new ArrayList<>();
		for (char[] dependency : dependencies) {
			ArrayList<Character> dependencyList = new ArrayList<>();
			dependencyList.add(dependency[0]);
			dependencyList.add(dependency[1]);
			dependenciesList.add(dependencyList);
		}
		List<Character> list = findCompilationOrder(dependenciesList);
		System.out.println(list);
	}

	public static List<Character> findCompilationOrder(ArrayList<ArrayList<Character>> dependencies) {
		List<Character> result = new ArrayList<>();
		Set<Character> charsSet = new TreeSet<>();
		for (ArrayList<Character> dependency : dependencies) {
			charsSet.add(dependency.get(0));
			charsSet.add(dependency.get(1));
		}
		Map<Character, Integer> charIntMap = new HashMap<>();
		Map<Integer, Character> intCharMap = new HashMap<>();
		int counter = 0;
		for (Character val : charsSet) {
			charIntMap.put(val, counter);
			intCharMap.put(counter, val);
			counter++;
		}
		List<List<Integer>> adjList = new ArrayList<>();
		int[] indegree = new int[charsSet.size()];
		for (int i = 0; i < indegree.length; i++) {
			adjList.add(new ArrayList<>());
		}
		for (ArrayList<Character> dependency : dependencies) {
			Character destChar = dependency.get(0);
			Character srcChar = dependency.get(1);
			int destCharIdx = charIntMap.get(destChar);
			int srcCharIdx = charIntMap.get(srcChar);
			adjList.get(srcCharIdx).add(destCharIdx);
			indegree[destCharIdx]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		List<Integer> topo = new ArrayList<>();
		while (!queue.isEmpty()) {
			int currVertex = queue.poll();
			topo.add(currVertex);
			List<Integer> neighbours = adjList.get(currVertex);
			for (int val : neighbours) {
				indegree[val]--;
				if (indegree[val] == 0) {
					queue.add(val);
				}
			}
		}

		for (int val : topo) {
			result.add(intCharMap.get(val));
		}
		return result;
	}

}
