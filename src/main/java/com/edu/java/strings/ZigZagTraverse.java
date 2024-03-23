package com.edu.java.strings;

public class ZigZagTraverse {

	public static void main(String[] args) {
		//String s = "AB";
		 String s = "PAYPAL";
		int numRows = 1;
		Character[][] res = convert(s, numRows);
		StringBuilder sb = new StringBuilder();
		for (int rowIdx = 0; rowIdx < res.length; rowIdx++) {
			for (int colIdx = 0; colIdx < res[rowIdx].length; colIdx++) {
				if (res[rowIdx][colIdx] != null) {
					sb.append(res[rowIdx][colIdx]);
				}
			}
		}
		String result =  sb.toString();
		System.out.println(result);
	}

	public static Character[][] convert(String s, int numRows) {
		Character[][] res = new Character[numRows][s.length()];
		int sr = 0;
		int er = numRows - 1;
		int sc = 0;
		int ec = res[0].length;
		int idx = 0;
		while (sr <= er && sc <= ec && idx < s.length()) {
			for (int rowIdx = sr; rowIdx < numRows && idx < s.length(); rowIdx++) {
				System.out.println("rowIdx :: " + rowIdx + " colIdx :: " + sc + " char is ::" + s.charAt(idx));
				res[rowIdx][sc] = s.charAt(idx++);
			}
			for (int rowIdx = er - 1; rowIdx > 0 && idx < s.length(); rowIdx--) {
				sc += 1;
				System.out.println("rowIdx :: " + rowIdx + " colIdx :: " + sc + " char is ::" + s.charAt(idx));
				res[rowIdx][sc] = s.charAt(idx);
				idx++;
			}
			sc += 1;
			sr = 0;
			er = numRows - 1;
		}
		return res;
	}

}
