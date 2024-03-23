package com.edu.java.graph;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckIfPathExistsDFS {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CheckIfPathExistsDFS.class);

    public static void main(String[] args) {
        int conGraphVertices = 5;
        Graph conGraph = connectedGraph(conGraphVertices);
        int sourceVertex = 2;
        int targetVertex = 3;
        boolean[] visited = new boolean[conGraph.adjLst.size()];
        boolean isPathExists = checkIfPathExists(conGraph.adjLst, visited, sourceVertex, targetVertex);
        LOGGER.info("Path from Source Vertex {}  to Target Vertex {} {}", sourceVertex , targetVertex, isPathExists ? " Exist" : " does not Exist");
    }

    private static boolean checkIfPathExists(List<List<Integer>> adjLst, boolean[] visited, int sourceVertex, int targetVertex) {

        if(sourceVertex == targetVertex)
            return true;

        visited[sourceVertex] = true;
        List<Integer> connectedVertices = adjLst.get(sourceVertex);
        for(Integer connectedVertex : connectedVertices) {
            if(visited[connectedVertex] == false && checkIfPathExists(adjLst, visited, connectedVertex, targetVertex)) {
                return true;
            }
        }

        return false;
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
