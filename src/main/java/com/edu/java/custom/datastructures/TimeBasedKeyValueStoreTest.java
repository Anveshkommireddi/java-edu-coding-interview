package com.edu.java.custom.datastructures;

public class TimeBasedKeyValueStoreTest {

	public static void main(String[] args) {

		TimeBasedKeyValueStore tkvStore = new TimeBasedKeyValueStore();
		boolean isSaved = tkvStore.setValue("course", "OOP", 3);
		String result = tkvStore.getValue("course", 5);
		System.out.println("isSaved " + isSaved + " and result is " + result);
		isSaved = tkvStore.setValue("course", "PF", 5);
		result = tkvStore.getValue("course", 4);
		System.out.println("isSaved " + isSaved + " and result is " + result);
		isSaved = tkvStore.setValue("course", "OS", 7);
		result = tkvStore.getValue("course", 10);
		System.out.println("isSaved " + isSaved + " and result is " + result);
		isSaved = tkvStore.setValue("course", "ALGO", 9);
		result = tkvStore.getValue("course", 2);
		System.out.println("isSaved " + isSaved + " and result is " + result);
		isSaved = tkvStore.setValue("course", "DB", 10);
		result = tkvStore.getValue("course", 3);
		System.out.println("isSaved " + isSaved + " and result is " + result);
	}
}
