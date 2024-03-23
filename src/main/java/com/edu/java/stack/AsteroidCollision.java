package com.edu.java.stack;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsteroidCollision {

	private static final Logger LOGGER = LoggerFactory.getLogger(AsteroidCollision.class);

	public static void main(String[] args) {
		int[] asteroids = { 4, -1, -2, -3 };
		int[] result = collidingAsteroids(asteroids);
		LOGGER.info("Result Array is {}", Arrays.asList(result));
	}

	private static int[] collidingAsteroids(int[] asteroids) {
		java.util.Stack<Integer> nonCollidingAsteroids = new java.util.Stack<>();
		for (int asteroid : asteroids) {
			int currAsteroid = asteroid;
			while (!nonCollidingAsteroids.isEmpty() && currAsteroid < 0 && nonCollidingAsteroids.peek() > 0) {
				if (Math.abs(currAsteroid) > Math.abs(nonCollidingAsteroids.peek())) {
					nonCollidingAsteroids.pop();
				} else if (Math.abs(currAsteroid) == Math.abs(nonCollidingAsteroids.peek())) {
					nonCollidingAsteroids.pop();
					currAsteroid = 0;
				} else {
					currAsteroid = 0;
				}
			}
			if (currAsteroid != 0) {
				nonCollidingAsteroids.push(currAsteroid);
			}
		}
		int[] result = new int[nonCollidingAsteroids.size()];
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = nonCollidingAsteroids.pop();
		}
		return result;
	}
}
