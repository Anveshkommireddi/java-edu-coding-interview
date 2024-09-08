package com.edu.rest.api.test;

public class ExceptionTest {

	public static void main(String[] args) {
		int result = getResult();
		System.out.println(result);
	}

	private static int getResult() {
		int result = 0;
		try {
			result = 2;
			return result;
		} catch (Exception exp) {

		} finally {
			result = -1;
		}
		return result;
	}

}
