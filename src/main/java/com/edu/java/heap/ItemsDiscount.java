package com.edu.java.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ItemsDiscount {

	public static void main(String[] args) {
		List<Integer> prices = Arrays.asList(2, 3, 1, 5, 6);
		int coupons = 2;
		int minPrice = getMinPrice(prices, coupons);
		System.out.println(minPrice);
	}

	private static int getMinPrice(List<Integer> prices, int coupons) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		maxHeap.addAll(prices);
		while (coupons > 0 && !maxHeap.isEmpty()) {
			Integer currMax = maxHeap.poll();
			Integer discountedPrice = currMax / 2;
			if (discountedPrice > 0) {
				maxHeap.add(discountedPrice);
			}
			coupons--;
		}

		int result = 0;
		while (!maxHeap.isEmpty()) {
			result += maxHeap.poll();
		}
		return result;
	}

}
