package com.edu.java.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = getCombinations(candidates, target);
        System.out.println(result);
    }

    private static List<List<Integer>> getCombinations(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currSet = new ArrayList<>();
        getUniqueCombinations2(candidates, 0, target, currSet, result);
        return result;
    }

    private static void collectCombinations(int[] candidates, int target, List<Integer> currSet, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(currSet));
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                currSet.add(candidates[i]);
                collectCombinations(candidates, target - candidates[i], currSet, result);
                currSet.remove(currSet.size() - 1);
            }
        }

    }

    private static void getUniqueCombinations(int[] candidates, int startIdx, int target, List<Integer> currSet, List<List<Integer>> result) {

        if (target < 0 || startIdx >= candidates.length)
            return;

        if (target == 0) {
            result.add(new ArrayList<>(currSet));
            return;
        }

        getUniqueCombinations(candidates, startIdx+ 1, target, currSet, result);
        currSet.add(candidates[startIdx]);
        getUniqueCombinations(candidates, startIdx, target - candidates[startIdx], currSet, result);
        currSet.remove(currSet.size() - 1);
    }

    private static void getUniqueCombinations2(int[] candidates, int startIdx, int target, List<Integer> currSet, List<List<Integer>> result) {

        if (target < 0 || startIdx >= candidates.length)
            return;

        if (target == 0) {
            result.add(new ArrayList<>(currSet));
            return;
        }

        for(int i = startIdx; i < candidates.length; i++) {
            currSet.add(candidates[i]);
            getUniqueCombinations(candidates, i, target - candidates[i], currSet, result);
            currSet.remove(currSet.size() - 1);
        }
    }

}