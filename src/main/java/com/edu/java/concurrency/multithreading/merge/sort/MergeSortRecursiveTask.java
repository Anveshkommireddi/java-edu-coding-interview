package com.edu.java.concurrency.multithreading.merge.sort;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class MergeSortRecursiveTask extends RecursiveAction {

	private static final long serialVersionUID = 1858322710969540420L;

	private int[] arr;

	public MergeSortRecursiveTask(int[] arr) {
		this.arr = arr;
	}

	@Override
	protected void compute() {
		
		if (arr.length <= 1) {
			return;
		}

		int mid = arr.length / 2;

		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);

		MergeSortRecursiveTask leftTask = new MergeSortRecursiveTask(left);
		MergeSortRecursiveTask rightTask = new MergeSortRecursiveTask(right);

		invokeAll(leftTask, rightTask);

		merge(left, right, arr);
	}

	// Merge two sorted arrays into one sorted array
	public static void merge(int[] left, int[] right, int[] arr) {
		int i = 0; 
	    int j = 0;
	    int k = 0;

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}

		while (i < left.length) {
			arr[k++] = left[i++];
		}

		while (j < right.length) {
			arr[k++] = right[j++];
		}
	}
}
