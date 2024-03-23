package com.edu.java.dp;

//LC : 1402
public class ReduceDishes {

	public static void main(String[] args) {
		// statisfaction values can be from -1000 to 1000
		//int[] satisfaction = { -1, -8, 0, 5, -9 };
		int[] satisfaction = {4,3,2};
		//int[] satisfaction = {-1,-4,-5};
		int[] sort = new int[2001];
		for (int i = 0; i < satisfaction.length; i++) {
			sort[satisfaction[i] + 1000]++;
		}

		int idx = 0;
		for (int i = 0; i < sort.length; i++) {
			while (sort[i]-- > 0) {
				satisfaction[idx++] = i - 1000;
			}
		}
		
		for(int i = 0; i < satisfaction.length; i++) {
			System.out.print(satisfaction[i] + " ");
		}
		System.out.println();
		
		int result = maxSatisfaction(satisfaction, 0, 1);
		System.out.println(result);
	}

	private static int maxSatisfaction(int[] arr, int idx, int time) {
		if(idx >= arr.length) return 0;
		int pick = arr[idx] * time + maxSatisfaction(arr, idx+1, time+1);
		int dontPick = maxSatisfaction(arr, idx+1, time);
		return Math.max(pick, dontPick);
	}

}
