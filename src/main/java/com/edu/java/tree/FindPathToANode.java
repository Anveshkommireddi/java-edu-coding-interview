package com.edu.java.tree;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindPathToANode {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FindPathToANode.class);
	
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        List<String> result = new ArrayList<>();
        List<String> currPath = new ArrayList<>();
        boolean isPathPresent = findPathToNode(root, 8, currPath, result);
        LOGGER.info("Path Present {} and Result is {}", isPathPresent, result);
    }

    private static boolean findPathToNode(Node root, Integer target, List<String> currPath, List<String> result) {

        if (null == root)
            return false;

        currPath.add(String.valueOf(root.data));
        if (root.data == target) {
            result.addAll(new ArrayList<>(currPath));
            return true;
        }

        boolean leftFlag = findPathToNode(root.left, target, currPath, result);
        boolean rightFlag = findPathToNode(root.right, target, currPath, result);
        currPath.remove(currPath.size() - 1);
        return root.data == target || leftFlag || rightFlag;


    }
}
