package com.edu.java.heap;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 12, 15, 14, 9, 2, 3, 16};
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }

    private static void heapSort(int[] arr) {
        buildMaxHeap(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            extractMax(arr, i);
        }
    }

    private static void extractMax(int[] arr, int currIdx) {
        int length = arr.length - currIdx;
        int max = arr[0];
        swap(arr, length - 1, 0);
        buildMaxHeap(arr, length - 1);
        arr[length - 1] = max;
    }

    private static void buildMaxHeap(int[] arr, int length) {
        for (int i = (length / 2) - 1; i >= 0; i--) {
            maxHeapify(arr, i, length);
        }
    }

    private static void maxHeapify(int[] arr, int currIdx, int length) {

        int largeIdx = currIdx;
        int leftChild = 2 * currIdx + 1;
        int rightChild = 2 * currIdx + 2;

        if (leftChild < length && arr[leftChild] > arr[largeIdx]) {
            largeIdx = leftChild;
        }

        if (rightChild < length && arr[rightChild] > arr[largeIdx]) {
            largeIdx = rightChild;
        }

        if (largeIdx != currIdx) {
            swap(arr, largeIdx, currIdx);
            maxHeapify(arr, largeIdx, length);
        }

    }

    private static void swap(int[] arr, int idx1, int idx2) {
        if (idx1 != idx2 && arr[idx1] != arr[idx2]) {
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }
    }

    private static void printArray(int[] arr) {
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
        System.out.println();
    }
}
