package com.edu.java.graph;

// LC :: 1466
public class ReOrderRoutesToMakeAllPathsLeadToCityZero {

	public static void main(String[] args) {
		int n = 6;
		int[][] connections = { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };
		int numOfFilps = getMinFilps(n, connections);
		System.out.println(numOfFilps);
	}

	private static int getMinFilps(int n, int[][] connections) {
		return 0;
	}

}
