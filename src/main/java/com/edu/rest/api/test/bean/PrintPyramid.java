package com.edu.rest.api.test.bean;

public class PrintPyramid {

	public static void main(String[] args) {
		int n = 5;
		for (int i = 1; i <= n; i++) {
			// print n-i spaces
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			// print i start
			for (int k = 1; k <= i; k++) {
				System.out.print("2 ");
			}
			System.out.println();
		}
	}

}
