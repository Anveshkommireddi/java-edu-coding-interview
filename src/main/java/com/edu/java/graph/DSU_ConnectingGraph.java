package com.edu.java.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DSU_ConnectingGraph {

	private static final Logger LOGGER = LoggerFactory.getLogger(DSU_ConnectingGraph.class);

	public static void main(String[] args) {
		int n = 4;
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
		int result = connectingGraph(edges, n);
		LOGGER.info("Result is {}", result);
	}

	private static int connectingGraph(int[][] edges, int n) {
		DisjointSetUnionBySize dsu = new DisjointSetUnionBySize(n-1);
		int extraEdges = 0;
		for(int[] edge : edges) {
			if(dsu.findUltimateParent(edge[0]) == dsu.findUltimateParent(edge[1])) {
				extraEdges++;
			} else {
				dsu.unionBySize(edge[0], edge[1]);
			}
		}
		return 0;
	}

}
