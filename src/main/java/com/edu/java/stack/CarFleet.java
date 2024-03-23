package com.edu.java.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CarFleet {

	private static final Logger LOGGER = LoggerFactory.getLogger(CarFleet.class);

	public static void main(String[] args) {

		int target = 12;

		int[] position = { 10, 8, 0, 5, 3 };

		int[] speed = { 2, 4, 1, 1, 3 };

		int numOfFleets = carFleet(position, speed, target);

		LOGGER.info("Total Number Of Fleets are {}", numOfFleets);
	}

	private static int carFleet(int[] position, int[] speed, int target) {
		List<Pair<Integer, Integer>> pairsList = new ArrayList<>();
		for (int i = 0; i < position.length; i++) {
			pairsList.add(new Pair<>(position[i], speed[i]));
		}
		List<Pair<Integer, Integer>> sortedPositionPairs = pairsList.stream()
				.sorted((pair1, pair2) -> pair2.getFirst() - pair1.getFirst()).collect(Collectors.toList());
		java.util.Stack<Double> stack = new java.util.Stack<>();
		for (int i = 0; i < sortedPositionPairs.size(); i++) {
			Pair<Integer, Integer> currPair = sortedPositionPairs.get(i);
			double timeTakenToReachTarget = (target - currPair.getFirst()) / (currPair.getLast() * 1.0);
			if (stack.isEmpty() || timeTakenToReachTarget > stack.peek()) {
				stack.push(timeTakenToReachTarget);
			}
		}
		return stack.size();
	}

}
