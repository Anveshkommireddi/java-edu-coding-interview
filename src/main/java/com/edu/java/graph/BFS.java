package com.edu.java.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {

        int discGraphVertices = 7;
        Graph discGraph = disconnectedGraph(discGraphVertices);
        List<Integer> bfsDiscReslLst = bfs(discGraph);
        System.out.println(bfsDiscReslLst);
        System.out.println("=================");
        int conGraphVertices = 5;
        Graph conGraph = connectedGraph(conGraphVertices);
        List<Integer> bfsConReslLst = bfs(conGraph);
        System.out.println(bfsConReslLst);
    }

    private static List<Integer> bfs(Graph graph) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> adjLst = graph.adjLst;
        if (null == adjLst || adjLst.isEmpty())
            return result;
        boolean[] visited = new boolean[adjLst.size()];
        for (int srcIdx = 0; srcIdx < adjLst.size(); srcIdx++) {
            if (visited[srcIdx] == false) {
                bfsFromASource(srcIdx, visited, adjLst, result);
            }
        }
        return result;
    }

    private static List<Integer> bfsFromASource(int sourceVertex, boolean[] visited, List<List<Integer>> adjLst, List<Integer> result) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceVertex);
        visited[sourceVertex] = true;

        while (!queue.isEmpty()) {
            Integer currVertex = queue.poll();
            result.add(currVertex);
            List<Integer> connectedVertices = adjLst.get(currVertex);
            for (Integer connectedVertex : connectedVertices) {
                if (visited[connectedVertex] == false) {
                    visited[connectedVertex] = true;
                    queue.add(connectedVertex);
                }
            }
        }
        return result;
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
