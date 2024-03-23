package com.edu.java.design.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {

	private static final Map<String, FlyWeight> flyWeightMap = new HashMap<>();

	public static FlyWeight getFlyweight(String key) {
		if (flyWeightMap.containsKey(key)) {
			return flyWeightMap.get(key);
		} else {
			FlyWeight flyWeight = new ConcreteFlyWeight(key);
			flyWeightMap.put(key, flyWeight);
			return flyWeight;
		}
	}

}
