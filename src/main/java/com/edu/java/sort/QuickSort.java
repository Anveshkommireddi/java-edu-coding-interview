package com.edu.java.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuickSort {

	private static final Logger LOGGER = LoggerFactory.getLogger(QuickSort.class);

	public static void main(String[] args) {
		int[] arr = {4, 1, 3, 9, 7};
		quickSort(arr, 0, arr.length - 1);
		LOGGER.info("Array is {}", arr);
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low >= high)
			return;
		int pIdx = partition(arr, low, high);
		quickSort(arr, low, pIdx - 1);
		quickSort(arr, pIdx + 1, high);
	}

	private static int partition(int[] arr, int low, int high) {
		int pIndex = low;
		int left = low + 1;
		int right = high;
		while (left <= right) {
			if (arr[left] > arr[pIndex] && arr[right] <= arr[pIndex]) {
				swap(arr, left, right);
			}
			if (left < arr.length && arr[left] <= arr[pIndex]) {
				left++;
			}
			if (right >= 0 && arr[right] > arr[pIndex]) {
				right--;
			}
		}
		swap(arr, pIndex, right);
		return right;
	}

	private static void swap(int[] arr, int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}
}
