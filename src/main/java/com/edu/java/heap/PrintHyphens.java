package com.edu.java.heap;

import java.util.stream.IntStream;

public class PrintHyphens {
	
	public static String repeat(String delimiter, int repeatCount) {
		StringBuilder sb = new StringBuilder();
		IntStream.rangeClosed(1, repeatCount).forEach(num -> sb.append(delimiter));
		return sb.toString();
	}

}
