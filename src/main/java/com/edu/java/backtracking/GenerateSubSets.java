package com.edu.java.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubSets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 2;
        List<List<Integer>> result = generateSubSets(nums);
    }

    private static List<List<Integer>> generateSubSets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currResult = new ArrayList<>();
        for (int k = 0; k <= nums.length; k++) {
            int startIdx = 0;
            backTracking(nums, startIdx, currResult, result, k);
        }

        System.out.println(result);
        return result;
    }

    private static void backTracking(int[] nums, int startIdx, List<Integer> currResult, List<List<Integer>> result, int k) {

        if (currResult.size() == k) {
            result.add(new ArrayList<>(currResult));
            return;
        }

        for (int i = startIdx; i < nums.length; i++) {
            currResult.add(nums[i]);
            backTracking(nums, i + 1, currResult, result, k);
            currResult.remove(currResult.size() - 1);
        }
    }
}
