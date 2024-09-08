package com.edu.java.custom.datastructures;

public class TimeBasedKeyValueStoreTest {

	public static void main(String[] args) {

		TimeBasedKeyValueStore tbKVStore = new TimeBasedKeyValueStore();
		boolean isSaved = tbKVStore.setValue("course", "OOP", 3);
		String result = tbKVStore.getValue("course", 5);
		System.out.println("isSaved " + isSaved + " and result is " + result);
		isSaved = tbKVStore.setValue("course", "PF", 5);
		result = tbKVStore.getValue("course", 4);
		System.out.println("isSaved " + isSaved + " and result is " + result);
		isSaved = tbKVStore.setValue("course", "OS", 7);
		result = tbKVStore.getValue("course", 10);
		System.out.println("isSaved " + isSaved + " and result is " + result);
		isSaved = tbKVStore.setValue("course", "ALGO", 9);
		result = tbKVStore.getValue("course", 2);
		System.out.println("isSaved " + isSaved + " and result is " + result);
		isSaved = tbKVStore.setValue("course", "DB", 10);
		result = tbKVStore.getValue("course", 3);
		System.out.println("isSaved " + isSaved + " and result is " + result);
	}
}
