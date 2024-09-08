package com.edu.java8.test;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringPathChanger {

	public static void main(String[] args) {
		String result = changeDirectoryString("/dev/task", "cd /java/../");
		System.out.println(result);
	}

	public static String changeDirectoryString(String currentDirectory, String command) {
		if (null == command || !command.startsWith("cd ")) {
			throw new IllegalStateException();
		}
		String updatedCommand = command.substring(3);
		boolean allSlash = checkAllSlashes(updatedCommand);
		if (allSlash == true) {
			return "/";
		}
		Deque<String> directoryStack = new ArrayDeque<>();
		boolean startsWithSlash = updatedCommand.trim().startsWith("/");
		if (startsWithSlash) {
			updatedCommand = updatedCommand.substring(1);
		} else {
			String updateCurrDirectory = currentDirectory.substring(1);
			String[] directories = updateCurrDirectory.split("/");
			for (String directory : directories) {
				directoryStack.addFirst(directory);
			}
		}
		String[] commands = updatedCommand.split("/");

		for (String currCommand : commands) {
			if (currCommand.isEmpty() || currCommand.equals(".")) {
				continue;
			} else if (currCommand.equals("..")) {
				if (!directoryStack.isEmpty()) {
					directoryStack.removeFirst();
				}
			} else if (currCommand.matches("[A-Za-z0-9-_]*")) {
				directoryStack.addFirst(currCommand);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!directoryStack.isEmpty()) {
			String val = directoryStack.removeLast();
			sb.append("/").append(val);
		}
		return sb.length() == 0 ? "/" : sb.toString();
	}

	private static boolean checkAllSlashes(String input) {
		int length = input.length();
		int slashLength = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '/') {
				slashLength++;
			}
		}
		return length == slashLength;
	}

}
