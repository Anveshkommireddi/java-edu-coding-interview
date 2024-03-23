package com.edu.java.bst;

import java.util.Arrays;
import java.util.TreeSet;

public class CeilOnLeftSide {
    public static void main(String[] args) {
        int[] arr = {2, 8, 30, 15, 25, 12};
        int[] res = ceilOnLeftSide(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] ceilOnLeftSide(int[] arr) {
        int[] result = new int[arr.length];
        TreeSet<Integer> bst = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            int currVal = arr[i];
            Integer ceil = bst.ceiling(currVal);
            result[i] = null == ceil ? -1 : ceil;
            bst.add(currVal);
        }
        return result;
    }
}
