package com.edu.java.dp;

public class DP_54_Interleaving_Strings {

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		boolean isValid = isInterleave(s1, s2, s3);
		System.out.println(isValid);
	}

	private static boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		Boolean[][][] mem = new Boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
		return interLeavingHelper(s1, 0, s2, 0, s3, 0, mem);
	}

	private static boolean interLeavingHelper(String s1, int s1Idx, String s2, int s2Idx, String s3, int s3Idx,
			Boolean[][][] mem) {
		if (s1.length() == s1Idx && s2.length() == s2Idx && s3.length() == s3Idx) {
			return true;
		}
		if (null != mem[s1Idx][s2Idx][s3Idx]) {
			return mem[s1Idx][s2Idx][s3Idx];
		}
		if (s1Idx < s1.length() && s2Idx < s2.length() && s3Idx < s3.length() && s1.charAt(s1Idx) == s3.charAt(s3Idx)
				&& s2.charAt(s2Idx) == s3.charAt(s3Idx)) {
			return mem[s1Idx][s2Idx][s3Idx] = interLeavingHelper(s1, s1Idx + 1, s2, s2Idx, s3, s3Idx + 1, mem)
					|| interLeavingHelper(s1, s1Idx, s2, s2Idx + 1, s3, s3Idx + 1, mem);
		} else if (s1Idx < s1.length() && s3Idx < s3.length() && s1.charAt(s1Idx) == s3.charAt(s3Idx)) {
			return mem[s1Idx][s2Idx][s3Idx] = interLeavingHelper(s1, s1Idx + 1, s2, s2Idx, s3, s3Idx + 1, mem);
		} else if (s2Idx < s2.length() && s3Idx < s3.length() && s2.charAt(s2Idx) == s3.charAt(s3Idx)) {
			return mem[s1Idx][s2Idx][s3Idx] = interLeavingHelper(s1, s1Idx, s2, s2Idx + 1, s3, s3Idx + 1, mem);
		}
		return mem[s1Idx][s2Idx][s3Idx] = false;
	}

}
