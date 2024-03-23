package com.edu.java.arrays;

import java.util.HashMap;
import java.util.Map;

public class CountPairsDivisibleByK {

    public static void main(String[] args) {
        int[] input1 = {2, 2, 1, 7, 5, 3};
        int k1 = 4;
        int result1 = countPairsDivisibleByK(input1, k1);
        System.out.println("Result1 is :: " + result1);
        int[] input2 = {5, 9, 36, 74, 52, 31, 42};
        int k2 = 3;
        int result2 = countPairsDivisibleByK(input2, k2);
        System.out.println("Result2 is :: " + result2);
    }

    private static int countPairsDivisibleByK(int[] input, int k) {
        int result = 0;
        Map<Integer, Integer> remainderCountMap = new HashMap<>();
        for (Integer num : input) {
            Integer rem = num % k;
            Integer match = rem != 0 ? k - rem : 0;
            Integer val = remainderCountMap.getOrDefault(match, 0);
            result += val;
            remainderCountMap.put(rem, remainderCountMap.getOrDefault(rem, 0) + 1);
        }
        return result;
    }
}
