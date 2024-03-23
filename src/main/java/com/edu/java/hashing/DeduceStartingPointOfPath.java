package com.edu.java.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeduceStartingPointOfPath {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DeduceStartingPointOfPath.class);

	public static void main(String[] args) {
		HashMap<String, String> hMap = new HashMap<>();
		hMap.put("NewYork", "Chicago");
		hMap.put("Boston", "Texas");
		hMap.put("Missouri", "NewYork");
		hMap.put("Texas", "Missouri");
		String actual_output = tracePath(hMap);
		LOGGER.info("Actual Output is {}", actual_output);
	}

	private static String tracePath(HashMap<String, String> hMap) {
		Set<String> starts = new HashSet<>(hMap.keySet());
		Set<String> destinations = new HashSet<>(hMap.values());
		starts.removeAll(destinations);
		if (starts.size() != 1) {
			return "NULL";
		}

		List<String> startsList = new ArrayList<>(starts);
		String start = startsList.get(0);
		String currStart = start;
		StringBuilder sb = new StringBuilder();
		while (null != currStart) {
			sb.append(currStart);
			if (null != hMap.get(currStart)) {
				sb.append(" -----> ");
			}
			currStart = hMap.get(currStart);
		}
		return sb.toString();
	}

}
