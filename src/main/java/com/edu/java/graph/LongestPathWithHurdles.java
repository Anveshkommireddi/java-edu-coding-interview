package com.edu.java.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongestPathWithHurdles {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LongestPathWithHurdles.class);

    private static int maxLength = 0;

    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 0, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

        // find the longest path with source (0, 0) and destination (1, 7)
        findLongestPath(mat, 0, 0, 1, 7);

        LOGGER.info("{}", maxLength);
    }

    private static void findLongestPath(int[][] mat, int xs, int ys, int xd, int yd) {

        longestPath(mat, xs, ys, xd, yd, 0);
    }

    private static void longestPath(int[][] mat, int sx, int sy, int dx, int dy, int currLength) {

        if (sx == dx && sy == dy) {
            maxLength = Math.max(maxLength, currLength);
            return;
        }

        mat[sx][sy] = 2;
        int[][] coordinates = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < coordinates.length; i++) {
            int[] coordinate = coordinates[i];
            int newX = sx + coordinate[0];
            int newY = sy + coordinate[1];
            if (newX >= 0 && newY >= 0 && newX < mat.length && newY < mat[0].length && mat[newX][newY] == 1) {
                longestPath(mat, newX, newY, dx, dy, currLength + 1);
            }
        }
        mat[sx][sy] = 1;
    }
}
