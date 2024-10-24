package com.edu.java.graph;

import java.util.Arrays;
import java.util.List;

public class ReConstructFlightPath {

	public static void main(String[] args) {
		List<List<String>> tickets = Arrays.asList(Arrays.asList("HOU", "JFK"), Arrays.asList("SEA", "JFK"),
				Arrays.asList("JFK", "SEA"), Arrays.asList("JFK", "HOU"));
		List<String> ticketsPath = findItinerary(tickets);
		System.out.println(ticketsPath);
	}

	public static List<String> findItinerary(List<List<String>> tickets) {
		return null;
	}

}
