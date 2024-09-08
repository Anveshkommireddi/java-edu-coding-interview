package com.edu.java.stack;

import java.util.HashSet;
import java.util.Set;

public class MinRemoveParanthesis {

	public static void main(String[] args) {
		String input = "ab)ca(so)(sc(s)(";
		String result = minParamRemoval(input);
		System.out.println(result);
		String emojiString = "🦋🦋🦋 Hello, world! 😊 🌍 🚀🕵🏻 🦋🦋🦋";
		System.out.println(emojiString);
	}

	private static String minParamRemoval(String input) {
		java.util.Stack<Integer> stack = new java.util.Stack<>();
		for (int i = 0; i < input.length(); i++) {
			char currChar = input.charAt(i);
			if (Character.isAlphabetic(currChar) || Character.isWhitespace(currChar))
				continue;
			if (!stack.isEmpty() && input.charAt(stack.peek()) == '(' && currChar == ')') {
				stack.pop();
			} else {
				stack.push(i);
			}
		}
		Set<Integer> invalidIdxSet = new HashSet<>();
		while (!stack.isEmpty()) {
			invalidIdxSet.add(stack.pop());
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (invalidIdxSet.contains(i))
				continue;
			sb.append(input.charAt(i));
		}
		return sb.toString();
	}

}
