package com.edu.java.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllPathsFromSourceToTarget {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AllPathsFromSourceToTarget.class);

    public static void main(String[] args) {
        int discGraphVertices = 7;
        Graph discGraph = disconnectedGraph(discGraphVertices);
        List<List<Integer>> discGraphAllPaths = allPathFromSrcToDest(discGraph, 0, 6);
		LOGGER.info("{}", discGraphAllPaths);
		LOGGER.info("{}", "=================");
        int conGraphVertices = 5;
        Graph conGraph = connectedGraph(conGraphVertices);
        List<List<Integer>> conGraphAllPaths = allPathFromSrcToDest(conGraph, 0, 4);
        LOGGER.info("{}", conGraphAllPaths);
    }

    private static List<List<Integer>> allPathFromSrcToDest(Graph graph, Integer source, Integer destination) {
        List<List<Integer>> resultPaths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        List<List<Integer>> adjList = graph.adjLst;
        boolean[] visited = new boolean[adjList.size()];
        dfsToPaths(adjList, visited, currPath, resultPaths, source, destination);
        return resultPaths;
    }

    private static void dfsToPaths(List<List<Integer>> adjList, boolean[] visited, List<Integer> currPath, List<List<Integer>> resultPaths, Integer source, Integer destination) {

       visited[source] = true;
       currPath.add(source);

        if (Objects.equals(source, destination)) {
            resultPaths.add(new ArrayList<>(currPath));
        }

        if(!Objects.equals(source, destination)) {
            List<Integer> connectedVertices = adjList.get(source);
            for (Integer connectedVertex : connectedVertices) {
                if (visited[connectedVertex] == false)
                    dfsToPaths(adjList, visited, currPath, resultPaths, connectedVertex, destination);
            }
        }
        visited[source] = false;
        currPath.remove(currPath.size() - 1);
    }


    private static Graph disconnectedGraph(int totalVertices) {
        Graph graph = new Graph(totalVertices);
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
        Graph graph = new Graph(totalVertices);
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
