package com.edu.java.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {

    public static void main(String[] args) {
        int[][] input = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        List<Integer> result = spiralTraversal(input);
        System.out.println(result);
    }

    private static List<Integer> spiralTraversal(int[][] input) {

        int startRow = 0;
        int endRow = input.length - 1;
        int startCol = 0;
        int endCol = input[0].length - 1;
        List<Integer> result = new ArrayList<>();

        while (startRow <= endRow && startCol <= endCol) {

            for (int colIdx = startCol; colIdx <= endCol; colIdx++) {
                result.add(input[startRow][colIdx]);
            }
            startRow++;

            for (int rowIdx = startRow; rowIdx <= endRow; rowIdx++) {
                result.add(input[rowIdx][endCol]);
            }
            endCol--;

            for (int colIdx = endCol; colIdx >= startCol; colIdx--) {
                if (startRow > endRow) break;
                result.add(input[endRow][colIdx]);
            }
            endRow--;

            for (int rowIdx = endRow; rowIdx >= startRow; rowIdx--) {
                if (startCol > endCol) break;
                result.add(input[rowIdx][startCol]);
            }
            startCol++;
        }
        return result;
    }
}
