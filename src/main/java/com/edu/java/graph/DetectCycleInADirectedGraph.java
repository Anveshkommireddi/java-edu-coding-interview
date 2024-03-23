package com.edu.java.graph;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DetectCycleInADirectedGraph {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DetectCycleInADirectedGraph.class);

    public static void main(String[] args) {
        int discGraphVertices = 7;
        Graph discGraph = disconnectedGraph(discGraphVertices);
        boolean isCyclePresent = detectCycleInADirectedGraph(discGraph);
        LOGGER.info("{}", isCyclePresent);
        LOGGER.info("{}", "=================");
        int conGraphVertices = 5;
        Graph conGraph = connectedGraph(conGraphVertices);
        isCyclePresent = detectCycleInADirectedGraph(conGraph);
        LOGGER.info("{}", isCyclePresent);
    }

    private static boolean detectCycleInADirectedGraph(Graph graph) {
        List<List<Integer>> adjList = graph.adjLst;
        boolean[] visited = new boolean[adjList.size()];
        boolean[] recStack = new boolean[adjList.size()];
        for (int srcIdx = 0; srcIdx < adjList.size(); srcIdx++) {
            if (visited[srcIdx] == false) {
                boolean result = cycleDetectionInDirectedGraphUsingDFS(adjList, visited, recStack, srcIdx);
                if (result == true)
                    return true;
            }
        }
        return false;
    }

    private static boolean cycleDetectionInDirectedGraphUsingDFS(List<List<Integer>> adjList, boolean[] visited, boolean[] recStack, int srcIdx) {
        visited[srcIdx] = true;
        recStack[srcIdx] = true;
        List<Integer> connectedVertices = adjList.get(srcIdx);
        for (Integer connectedVertex : connectedVertices) {
            if (visited[connectedVertex] == false) {
                boolean result = cycleDetectionInDirectedGraphUsingDFS(adjList, visited, recStack, connectedVertex);
                if (result == true)
                    return true;
            } else if (visited[connectedVertex] == true && recStack[connectedVertex] == true) {
                return true;
            }
        }
        recStack[srcIdx] = false;
        return false;
    }

    private static Graph disconnectedGraph(int totalVertices) {
        Graph graph = new Graph(totalVertices, true);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(4, 6);
        graph.printGraph();
        return graph;
    }

    private static Graph connectedGraph(int totalVertices) {
        Graph graph = new Graph(totalVertices, true);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 4);
        graph.printGraph();
        return graph;
    }
}
