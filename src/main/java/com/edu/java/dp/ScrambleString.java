package com.edu.java.dp;

// LC :: 87
public class ScrambleString {

	public static void main(String[] args) {
		String input1 = "team";
		String input2 = "meat";
		boolean isScramble = isScramble(input1, input2);
		System.out.println(isScramble);
	}

	public static boolean isScramble(String a, String b) {
		if (a.equals(b) == true) return true;
		if (a.length() != b.length()) return false;
		if (a.isEmpty() == true) return true;
		return helper(a, b);
	}

	public static boolean helper(String a, String b) {
		if (a.equals(b) == true) return true;
		if (a.length() <= 1) return false;
		int n = a.length();
		boolean check = false;
		for (int i = 1; i < n; i++) {
			boolean swap = helper(a.substring(0, i), b.substring(n - i)) && helper(a.substring(i), b.substring(0, n - i));
			boolean unswap = helper(a.substring(0, i), b.substring(0, i)) && helper(a.substring(i), b.substring(i));
			if (swap || unswap) {
				return true;
			}
		}
		return check;
	}

}
