package com.edu.java.arrays;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NextPermutation {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NextPermutation.class);
	
	public static void main(String[] args) {
		int[] arr = { 7, 2, 5, 3, 1 };
		LOGGER.info("{}", Arrays.toString(arr));
		nextPermutation(arr);
		LOGGER.info("{}", Arrays.toString(arr));
	}

	private static void nextPermutation(int[] arr) {
		
		int infIdx = 0;
		//find inflection point
		for(int idx = arr.length-1; idx > 0; idx--) {
			if(arr[idx] > arr[idx-1]) {
				infIdx = idx;
				break;
			}
		}
		
		if(infIdx == 0) {
			Arrays.sort(arr);
			return;
		}
		//find the next largest number to the inflection-1
		int toSwapIdx = infIdx - 1;
		int fromSwapIdx = 0;
		int min = Integer.MAX_VALUE;
		for(int idx = infIdx; idx < arr.length; idx++) {
			if(arr[idx] > arr[toSwapIdx]) {
				if(arr[idx] < min) {
					fromSwapIdx = idx;
					min = Math.min(arr[idx], min);
				}
			}
		}
		
		//swap fromSwapIdx to toSwapIdx
		swap(arr, fromSwapIdx, toSwapIdx);
		
		//sort all the elements from inflection point
		Arrays.sort(arr, infIdx, arr.length);
		
	}

	private static void swap(int[] arr, int fromSwapIdx, int toSwapIdx) {
		int temp = arr[fromSwapIdx];
		arr[fromSwapIdx] = arr[toSwapIdx];
		arr[toSwapIdx] = temp;
	}

}
