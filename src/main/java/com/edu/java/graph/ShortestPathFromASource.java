package com.edu.java.graph;

import java.util.*;

public class ShortestPathFromASource {

    public static void main(String[] args) {
        int conGraphVertices = 5;
        Graph conGraph = connectedGraph(conGraphVertices);
        int sourceVertex = 0;
        int[] distance = shortestPathFromASource(conGraph, sourceVertex);
        Arrays.stream(distance).forEach(number -> System.out.print(number + " "));
    }

    private static int[] shortestPathFromASource(Graph graph, int sourceVertex) {
        int[] distance = new int[graph.adjLst.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        List<List<Integer>> adjList = graph.adjLst;
        if (null == adjList || adjList.isEmpty())
            return distance;
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceVertex);
        visited[sourceVertex] = true;
        distance[sourceVertex] = 0;
        while (queue.isEmpty() == false) {
            Integer currVertex = queue.poll();
            List<Integer> connectedVertices = adjList.get(currVertex);
            for (Integer connectedVertex : connectedVertices) {
                if (visited[connectedVertex] == false) {
                    visited[connectedVertex] = true;
                    distance[connectedVertex] = distance[currVertex] + 1;
                    queue.add(connectedVertex);
                }
            }
        }
        return distance;
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
