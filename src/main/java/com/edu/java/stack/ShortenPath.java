package com.edu.java.stack;

import java.util.Iterator;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShortenPath {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShortenPath.class);

	public static void main(String[] args) {
		String inputPath = "/a/./b/./c/./d/";
		String[] directories = inputPath.split("/");
		Stack<String> result = new Stack<>();
		for (String field : directories) {
			if (field.equals("..")) {
				if (!result.isEmpty()) {
					result.pop();
				}
			} else if (field.equals(".") || field.equals("")) {
				continue;
			} else {
				result.push(field);
			}
		}

		LOGGER.info("OldPath is {}", inputPath);
		Iterator<String> stackIterator = result.iterator();
		while(stackIterator.hasNext()) {
			System.out.println(stackIterator.next());
		}
		LOGGER.info("NewPath is {}", "/" + String.join("/", result));
	}

}
