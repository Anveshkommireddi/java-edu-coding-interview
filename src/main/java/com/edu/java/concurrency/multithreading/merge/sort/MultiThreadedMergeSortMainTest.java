package com.edu.java.concurrency.multithreading.merge.sort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class MultiThreadedMergeSortMainTest {

	public static void main(String[] args) {

		int[] arr = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Original array: " + Arrays.toString(arr));

		try (ForkJoinPool pool = new ForkJoinPool()) {
			MergeSortRecursiveTask msTask = new MergeSortRecursiveTask(arr);
			pool.invoke(msTask);
		}
		System.out.println("Sorted array: " + Arrays.toString(arr));
	}

}
