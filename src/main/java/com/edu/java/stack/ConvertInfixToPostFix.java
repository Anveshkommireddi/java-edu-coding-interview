package com.edu.java.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ConvertInfixToPostFix {

	static List<Character> operandList = Arrays.asList('+', '-', '*', '/');
	static Map<Character, Integer> precedenceInfo;

	static {
		precedenceInfo = new HashMap<>();
		precedenceInfo.put('+', 0);
		precedenceInfo.put('-', 0);
		precedenceInfo.put('*', 1);
		precedenceInfo.put('/', 1);
		precedenceInfo.put('^', 2);
	}

	public static void main(String... args) {
		String infix = "a+b/(d*f+c)*e";
		String postfix = convertInfixToPostFix(infix);
		System.out.println("Infix Expression is " + infix);
		System.out.println("PostFix Expression is " + postfix);
	}

	/**
	 1) Maintain a stack with Low to High Precedence ( +,- Low precedence, *,/ high precedence, ^ highest precedence
	 2) If (, operand push into stack
	 3) If ) pull the elements from the stack until we pop (
	 4) if operator make sure we maintain low to high precedence by popping the elements from stack do compare if previous is (
	 */
	private static String convertInfixToPostFix(String infix) {
		StringBuilder resultBuilder = new StringBuilder();
		Stack<Character> operatorStack = new Stack<>();
		for(int i = 0; i < infix.length(); i++) {
			Character currChar = infix.charAt(i);
			if(Character.isAlphabetic(currChar)) {
				resultBuilder.append(currChar);
			} else if(currChar == '(') {
				operatorStack.push(currChar);
			} else if(operandList.contains(currChar)) {
				while (!operatorStack.isEmpty() && (operandList.contains(operatorStack.peek())
						&& precedenceInfo.get(currChar) <= precedenceInfo.get(operatorStack.peek()))) {
					resultBuilder.append(operatorStack.pop());
				}
				operatorStack.push(currChar);
			} else if(currChar == ')') {
				while(!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					resultBuilder.append(operatorStack.pop());
				}
				operatorStack.pop();
			} 
		}
		
		while(!operatorStack.isEmpty()) {
			resultBuilder.append(operatorStack.pop());
		}
		return resultBuilder.toString();
	}
}
