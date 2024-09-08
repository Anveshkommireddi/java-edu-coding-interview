package com.edu.java.custom.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomn {

	private List<Integer> valuesList;

	private Map<Integer, Integer> valIdxMap;

	private Random random;

	public InsertDeleteGetRandomn() {
		valuesList = new ArrayList<>();
		valIdxMap = new HashMap<>();
		random = new Random();
	}

	public boolean insert(int val) {
		if (valIdxMap.containsKey(val))
			return false;
		int idx = valuesList.size();
		valIdxMap.put(val, idx);
		valuesList.add(idx, val);
		return true;
	}

	public boolean delete(int val) {
		if (!valIdxMap.containsKey(val))
			return false;
		int reqListIdx = valIdxMap.get(val);
		int lastVal = valuesList.get(valuesList.size() - 1);
		valuesList.add(reqListIdx, lastVal);
		valuesList.remove(valuesList.size() - 1);
		valIdxMap.remove(val);
		valIdxMap.put(lastVal, reqListIdx);
		return true;
	}

	public int getRandomData() {
		return valuesList.get(random.nextInt(valuesList.size()));
	}

}
