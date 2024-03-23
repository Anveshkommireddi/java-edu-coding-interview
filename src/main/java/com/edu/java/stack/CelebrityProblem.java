package com.edu.java.stack;

import java.util.Stack;

public class CelebrityProblem {

	public static void main(String args[]) {

		int[][] party1 = { 
				{ 0, 1, 1, 0 }, 
				{ 1, 0, 1, 1 }, 
				{ 0, 0, 0, 0 }, 
				{ 0, 1, 1, 0 } };

		int[][] party2 = { 
				{ 0, 1, 1, 0 }, 
				{ 1, 0, 1, 1 }, 
				{ 0, 0, 0, 1 }, 
				{ 0, 1, 1, 0 } };

		int[][] party3 = { 
				{ 0, 0, 0, 0 }, 
				{ 1, 0, 0, 1 }, 
				{ 1, 0, 0, 1 }, 
				{ 1, 1, 1, 0 } };

		System.out.println(findCelebrity(party1, 4));
		System.out.println(findCelebrity(party2, 4));
		System.out.println(findCelebrity(party3, 4));
	}

	private static int findCelebrity(int[][] party, int numOfPersons) {

		Stack<Integer> persons = new Stack<>();

		int celebrity = -1;

		for (int currPerson = 0; currPerson < numOfPersons; currPerson++) {
			persons.add(currPerson);
		}

		while (!persons.isEmpty()) {

			int x = persons.pop();

			if (persons.isEmpty()) {
				celebrity = x;
				break;
			}

			int y = persons.pop();

			if (party[x][y] == 1) {
				persons.push(y);
			} else {
				persons.push(x);
			}
		}

		for (int currPerson = 0; currPerson < numOfPersons; currPerson++) {
			if (celebrity != currPerson && (party[celebrity][currPerson] == 1 || party[currPerson][celebrity] == 0))
				return -1;
		}
		return celebrity;
	}

}
