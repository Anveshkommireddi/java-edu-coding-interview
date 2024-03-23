package com.edu.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = getUniqueCombinations(candidates, target);
        System.out.println(result);
    }

    private static List<List<Integer>> getUniqueCombinations(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currSet = new ArrayList<>();
        int startIdx = 0;
        generateUniqueCombinations(candidates, startIdx, target, currSet, result);
        return result;
    }

    private static void generateUniqueCombinations(int[] candidates, int startIdx, int target, List<Integer> currSet, List<List<Integer>> result) {

        if(target < 0 || startIdx >= candidates.length)
            return;

        if(target == 0) {
            result.add(new ArrayList<>(currSet));
            return;
        }

        for (int i = startIdx; i < candidates.length; i++) {
            if (i > startIdx && candidates[i] == candidates[i - 1])
                continue;
            currSet.add(candidates[i]);
            generateUniqueCombinations(candidates, i+1, target-candidates[i], currSet, result);
            currSet.remove(currSet.size()-1);
        }
    }
}
