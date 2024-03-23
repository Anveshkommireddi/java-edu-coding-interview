package com.edu.java.hashing;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TracePath {

	public static void main(String[] args) {

		Map<String, String> hMap = new HashMap<>();
		hMap.put("NewYork", "Chicago");
		hMap.put("Boston", "Texas");
		hMap.put("Missouri", "NewYork");
		hMap.put("Texas", "Missouri");
		String actual_output = tracePath(hMap);
		System.out.println(actual_output);
	}

	private static String tracePath(Map<String, String> hMap) {
		Set<String> keySet = hMap.keySet();
		Collection<String> values =  hMap.values();
		String pathStart = null;
		for (String start : keySet) {
			if (!values.contains(start)) {
				pathStart = start;
				break;
			}
		}
		String result = "";
		if (pathStart != null) {
			while (null != hMap.get(pathStart)) {
				result += pathStart + "->" + hMap.get(pathStart) + ", ";
				pathStart = hMap.get(pathStart);
			}
		}
		return result;
	}

}
