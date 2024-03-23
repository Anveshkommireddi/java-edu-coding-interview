package com.edu.java.misc;

import java.util.HashMap;
import java.util.Map;

public class ThrottleGateway {
	public static void main(String[] args) {
		int[] request = { 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11 };
		// int[] request = { 1, 100, 200, 200 };
		int droppedReq = throttleGW(request);
		System.out.println(droppedReq);
	}

	private static int throttleGW(int[] request) {
		int dropped = 0;
		Map<Integer, Integer> prevDropped = new HashMap<>();
		for (int currsecond = 0; currsecond < request.length; currsecond++) {
			boolean throttleForASecond = currsecond > 2 && request[currsecond] == request[currsecond - 3];
			boolean throttleForTenSeconds = currsecond > 19 && request[currsecond] - request[currsecond - 20] < 10;
			boolean throttleFor60Seconds = currsecond > 59 && request[currsecond] - request[currsecond - 60] < 60;
			boolean droppedFlag = !prevDropped.containsKey(request[currsecond]) || prevDropped.get(request[currsecond]) != currsecond;
			if ((throttleForASecond || throttleForTenSeconds || throttleFor60Seconds) && droppedFlag) {
				prevDropped.put(request[currsecond], currsecond);
				dropped++;
			}
		}
		return dropped;
	}
}
