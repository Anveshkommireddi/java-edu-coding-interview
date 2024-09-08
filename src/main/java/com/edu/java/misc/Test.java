package com.edu.java.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		ConvertInfixToPostFixLC cip = new ConvertInfixToPostFixLC();
		// cip.calculate("12-( -2)");
		// groupAnagrams();
		// basicCalculator2();
		// searchInSortedRotatedArray();
		List<Integer> intvalsList = Arrays.asList(3, 1, 8, 20, 0, 100, 3, 6);
	}

	private static void searchInSortedRotatedArray() {
		// int[] nums = { 5, 6, 7, 8, 9, 10, 1, 2, 3, 4 };
		// int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] nums = { 3, 1 };
		int target = 0;
		int peakIdx = findPeakIdx(nums);
		if (peakIdx == -1) {
			System.out.println("Invalid PeakIdx");
			return;
		}
		int numOfRotations = nums.length - peakIdx;
		System.out.println("numOfRotations is " + numOfRotations);
		bs(nums, peakIdx, nums.length - 1, target);
		bs(nums, 0, peakIdx - 1, target);
	}

	private static void bs(int[] nums, int low, int high, int target) {
		while (low <= high) {

		}
	}

	private static int findPeakIdx(int[] nums) {
		int pivot = nums[0];
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid == nums.length - 1 || nums[mid] < nums[mid + 1]) && (mid == 0 || nums[mid] < nums[mid - 1])) {
				return mid;
			} else if (nums[mid] < pivot) {
				high = mid - 1;
			} else if (nums[mid] >= pivot) {
				low = mid + 1;
			}
		}
		return 0;
	}

	private static void groupAnagrams() {
		String[] words = { "eat", "tea", "tan", "ate", "nat", "bat" };
		Map<String, List<String>> hashAnagramsList = new HashMap<>();
		for (String word : words) {
			char[] hash = new char[26];
			for (int i = 0; i < word.length(); i++) {
				char currChar = word.charAt(i);
				int currCharIdx = currChar - 'a';
				hash[currCharIdx] = (char) (hash[currCharIdx] + 1);
			}
			String hashedWord = new String(hash);
			List<String> anagramsList = hashAnagramsList.getOrDefault(hashedWord, new ArrayList<>());
			anagramsList.add(word);
			hashAnagramsList.put(hashedWord, anagramsList);
		}
		System.out.println(hashAnagramsList.values());
	}

	private static void basicCalculator2() {
		String s = "42";

		char sign = '+';
		int num = 0;

		for (int i = 0; i < s.length(); i++) {
			char currChar = s.charAt(i);
			if (Character.isDigit(currChar)) {
				num = num * 10 + (currChar - '0');
			}
		}

		System.out.println(num);
	}

	private static void kokoEatingBananas() {
		int[] piles = { 3, 6, 7, 11 };
		int hours = 8;
		int result = minTimeToEatAllPiles(piles, hours);
		System.out.println(result);
	}

	private static int minTimeToEatAllPiles(int[] piles, int hours) {
		int low = 1;
		int high = 0;
		for (int pile : piles) {
			high = Math.max(pile, high);
		}
		int result = Integer.MAX_VALUE;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			boolean isPossible = calculateTime(piles, mid, hours);
			if (isPossible) {
				result = Math.min(result, mid);
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;
	}

	private static boolean calculateTime(int[] piles, int currSpeed, int maxHours) {
		int currHours = 0;
		for (int pile : piles) {
			int hoursTaken = pile / currSpeed;
			currHours += pile % currSpeed == 0 ? hoursTaken : hoursTaken + 1;
		}
		return currHours <= maxHours;
	}

	private static void nextPermutation() {
		int[] arr = { 7, 2, 5, 3, 1 };
		System.out.println(Arrays.toString(arr));
		nextPermutation(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void nextPermutation(int[] arr) {
		// find the inflection point.
		// if inflection point is present find the next greatest elements to the
		// inflection point
		// swap inflection with next greatest
		// sort the elements after inflection index
		int inflectionIdx = Integer.MAX_VALUE;
		for (int idx = arr.length - 1; idx > 0; idx--) {
			if(arr[idx - 1] < arr[idx]) {
				inflectionIdx = idx;
				break;
			}
		}
		
		if(inflectionIdx == Integer.MAX_VALUE) return;
		
		int toSwapIdx = inflectionIdx - 1;
	}

}
