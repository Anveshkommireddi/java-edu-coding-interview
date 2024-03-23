package com.edu.java.misc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class ConvertInfixToPostFixLC {

	static List<Character> operandList = Arrays.asList('+', '-');
	static Map<Character, Integer> precedenceInfo = new HashMap<>();

	static {
		precedenceInfo.put('+', 0);
		precedenceInfo.put('-', 0);
		precedenceInfo.put('*', 1);
		precedenceInfo.put('/', 1);
		precedenceInfo.put('^', 2);
	}

	public int calculate(String s) {
		int n = s.length();
		int res = 0; // Current result
		int num = 0; // Current number being parsed
		int sign = 1; // Current sign (+1 or -1)
		Deque<Integer> stack = new ArrayDeque<>(); // Stack to handle parentheses

		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10 + (c - '0'); // Build current number
			}
			if (c == '(') {
				// Push current result and sign onto stack
				stack.push(res);
				stack.push(sign);
				// Reset result and sign for new sub-expression
				res = 0;
				sign = 1;
			}
			if (c == ')') {
				// Evaluate sub-expression and combine with previous result
				res += sign * num;
				num = 0;
				sign = 1;
				res *= stack.pop(); // Previous sign
				res += stack.pop(); // Previous result
			}
			if (c == '+' || c == '-') {
				// Combine previous number with current result
				res += sign * num;
				num = 0;
				sign = c == '+' ? 1 : -1; // Update sign for next number
			}
		}
		// Combine last number with current result
		res += sign * num;
		return res;
	}

	private Queue<String> convertToPostFix(String infix) {
		Stack<Character> operatorStack = new Stack<>();
		Queue<String> queue = new LinkedList<>();
		for (int i = 0; i < infix.length(); i++) {
			char curr = infix.charAt(i);
			if (curr == ' ')
				continue;
			if (Character.isDigit(curr)) {
				int num = 0;
				while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
					num = num * 10 + (infix.charAt(i) - '0');
					i++;
				}
				i--;
				queue.add(String.valueOf(num));
			} else if (curr == '(') {
				operatorStack.push(curr);
			} else if (curr == ')') {
				while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					queue.add(String.valueOf(operatorStack.pop()));
				}
				operatorStack.pop();
			} else if (operandList.contains(curr)) {
				while (!operatorStack.isEmpty() && (operandList.contains(operatorStack.peek())
						&& precedenceInfo.get(curr) <= precedenceInfo.get(operatorStack.peek()))) {
					queue.add(String.valueOf(operatorStack.pop()));
				}
				operatorStack.push(curr);
			}
		}
		while (!operatorStack.isEmpty()) {
			queue.add(String.valueOf(operatorStack.pop()));
		}
		return queue;
	}

	private int evaluatePostFix(Queue<String> postFixQueue) {
		Stack<Integer> stack = new Stack<>();
		int postFixQueueSize = postFixQueue.size();
		for (int i = 0; i < postFixQueueSize; i++) {
			String curr = postFixQueue.poll();
			System.out.println(curr);
			if (!Arrays.asList("-", "+", "*", "/").contains(curr)) {
				stack.push(Integer.parseInt(curr));
			} else if (stack.size() >= 2) {
				Integer x = stack.pop();
				Integer y = stack.pop();
				switch (curr) {
				case "+":
					stack.push(y + x);
					break;
				case "-":
					stack.push(y - x);
					break;
				case "*":
					stack.push(y * x);
					break;
				case "/":
					stack.push(y / x);
					break;
				}
			}
		}
		return stack.pop();
	}
}
