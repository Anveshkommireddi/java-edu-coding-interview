package com.edu.java.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BasicCalculator {

	private static Map<Character, Integer> precedenceInfoMap;

	static {
		precedenceInfoMap = new HashMap<>();
		precedenceInfoMap.put('+', 1);
		precedenceInfoMap.put('-', 1);
		precedenceInfoMap.put('*', 2);
		precedenceInfoMap.put('/', 2);
	}

	public static void main(String[] args) {
		//String s = "(1+(49+5+2)-3)+(6+8)";
		String s = "1-(     -2)";
		calculate(s);
	}

	public static int calculate(String s) {
		String postFix = postFix(s);
		System.out.println("PostFix is "+ postFix);
		int result = evaluatePostfix(postFix);
		System.out.println("PostFix Result is "+ result);
		return result;
	}

	private static int evaluatePostfix(String postFix) {
		String[] vals = postFix.split(" ");
		java.util.Stack<Integer> operands = new java.util.Stack<>();
		for (int i = 0; i < vals.length; i++) {
			if (Arrays.asList("+", "-", "*", "/").contains(vals[i])) {
				String curr = vals[i];
				if (!operands.isEmpty() && operands.size() >= 2) {
					int x = operands.pop();
					int y = operands.pop();
					switch (curr) {
					case "+":
						int add = x + y;
						operands.push(add);
						break;
					case "-":
						int sub = y - x;
						operands.push(sub);
						break;
					case "*":
						int mul = y * x;
						operands.push(mul);
						break;
					case "/":
						int div = y / x;
						operands.push(div);
						break;
					}
				}
			} else {
				operands.push(Integer.parseInt(vals[i]));
			}
		}
		return operands.isEmpty() ? 0 : operands.pop();
	}

	private static String postFix(String input) {
		StringBuilder sb = new StringBuilder();
		java.util.Stack<Character> operatorStack = new java.util.Stack<>();
		for (int idx = 0; idx < input.length(); idx++) {
			char curr = input.charAt(idx);
			if (curr == ' ')
				continue;
			if (Character.isDigit(curr)) {
				int newIdx = getNum(input, idx, sb);
				idx = newIdx - 1;
			} else if (curr == '(') {
				operatorStack.push(curr);
			} else if (precedenceInfoMap.keySet().contains(curr)) {
				while (!operatorStack.isEmpty() && (precedenceInfoMap.keySet().contains(operatorStack.peek())
						&& precedenceInfoMap.get(operatorStack.peek()) >= precedenceInfoMap.get(curr))) {
					sb.append(operatorStack.pop()).append(" ");
				}
				operatorStack.push(curr);
			} else if (curr == ')') {
				while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					sb.append(operatorStack.pop()).append(" ");
				}
				operatorStack.pop();
			}
		}
		while (!operatorStack.isEmpty()) {
			sb.append(operatorStack.pop()).append(" ");
		}
		return sb.toString();
	}

	private static int getNum(String input, int idx, StringBuilder sb) {
		int num = 0;
		while (idx < input.length() && Character.isDigit(input.charAt(idx))) {
			int charNum = Character.getNumericValue(input.charAt(idx));
			num = num * 10 + charNum;
			idx++;
		}
		sb.append(num).append(" ");
		return idx;
	}

}
