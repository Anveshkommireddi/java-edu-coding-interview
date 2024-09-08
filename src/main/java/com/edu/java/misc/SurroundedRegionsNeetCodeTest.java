package com.edu.java.misc;

public class SurroundedRegionsNeetCodeTest {

	public static void main(String[] args) {
		char[][] input = { { 'X', 'X', 'X', 'X', 'X' }, 
				           { 'X', 'O', 'O', 'X', 'O' }, 
				           { 'X', 'X', 'O', 'X', 'O' },
				           { 'X', 'O', 'X', 'O', 'X' }, 
				           { 'O', 'O', 'X', 'X', 'X' } };
		NeetCode neetcode = new NeetCode();
		neetcode.solve(input);
		System.out.println(input);
	}

	
}
