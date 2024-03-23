package com.edu.java.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MergeArraysWithoutExtraSpace {

	private static final Logger LOGGER = LoggerFactory.getLogger(MergeArraysWithoutExtraSpace.class);

	public static void main(String[] args) {
		int n = 4;
		int[] arr1 = { 1, 3, 5, 7 };
		int m = 5;
		int[] arr2 = { 0, 2, 6, 8, 9 };
		merge(arr1, arr2, m, n);
		System.out.println("Done");
	}

	private static void merge(int[] arr1, int[] arr2, int m, int n) {
		int arr1Idx = arr1.length - 1;
		int arr2Idx = 0;

		while (arr2Idx < arr2.length && arr1Idx >= 0) {
			if (arr2[arr2Idx] < arr1[arr1Idx]) {
				int temp = arr2[arr2Idx];
				arr2[arr2Idx] = arr1[arr1Idx];
				arr1[arr1Idx] = temp;
				arr2Idx++;
				arr1Idx--;
			} else if (arr1[arr1Idx] <= arr2[arr2Idx]) {
				break;
			}
		}

		quickSort(arr1, 0, arr1.length - 1);
		quickSort(arr2, 0, arr2.length - 1);
	}

	private static void quickSort(int[] arr, int low, int high) {
		if(low >= high) return;
		int partitionIdx = partition(arr, low, high);
		quickSort(arr, low , partitionIdx - 1);
		quickSort(arr, partitionIdx + 1, high);
	}

	private static int partition(int[] arr, int low, int high) {
		int pIdx = low;
		int right = high;
		int left = low + 1;
		while(left <= right) {
			if(arr[left] > arr[pIdx] && arr[right] <= arr[pIdx]) {
				swap(arr, left, right);
			}
			
			if(left < arr.length && arr[left] <= arr[pIdx]) {
				left++;
			}
			
			if(right >= 0 && arr[right] > arr[pIdx]) {
				right--;
			}
		}
		swap(arr, pIdx, right);
		return right;
	}
	
	private static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

}
