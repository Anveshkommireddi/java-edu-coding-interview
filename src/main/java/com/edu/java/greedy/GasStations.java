package com.edu.java.greedy;

import java.util.Arrays;
import java.util.List;

public class GasStations {

    public static void main(String[] args) {
        int result = canCompleteCircuit(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(3, 4, 5, 1, 2));
        System.out.println(result);
    }

    public static int canCompleteCircuit(final List<Integer> currGas, final List<Integer> futureGas) {
        int start = 0;
        int extraFuel = 0;
       // required fuel is stored since we donot need to loop through the remaining elements starting from end
        int requiredFuel = 0;
        for (int idx = 0; idx < currGas.size(); idx++) {
            extraFuel += currGas.get(idx) - futureGas.get(idx);
            if (extraFuel < 0) {
                requiredFuel += extraFuel;
                start = idx + 1;
                extraFuel = 0;
            }
        }
        return extraFuel + requiredFuel >= 0 ? start : -1;
    }
}

