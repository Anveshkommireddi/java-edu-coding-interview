package com.edu.java.custom.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {

	Map<String, TreeMap<Integer, String>> keyTimeValueMap;

	public TimeBasedKeyValueStore() {
		keyTimeValueMap = new HashMap<>();
	}

	public boolean setValue(String key, String value, int timestamp) {
		TreeMap<Integer, String> timeStampValueMap = Optional.ofNullable(keyTimeValueMap.get(key))
				.orElse(new TreeMap<>());
		if (timeStampValueMap.get(timestamp) == value) {
			return false;
		}
		timeStampValueMap.put(timestamp, value);
		keyTimeValueMap.put(key, timeStampValueMap);
		return true;
	}

	public String getValue(String key, int timeStamp) {
		if (keyTimeValueMap.get(key) == null)
			return "";
		TreeMap<Integer, String> timeStampValueMap = Optional.ofNullable(keyTimeValueMap.get(key))
				.orElse(new TreeMap<>());
		if (null != timeStampValueMap.get(timeStamp))
			return timeStampValueMap.get(timeStamp);
		Integer floorKey = timeStampValueMap.floorKey(timeStamp);
		if (null == floorKey)
			return "";
		return timeStampValueMap.get(floorKey);
	}

}
