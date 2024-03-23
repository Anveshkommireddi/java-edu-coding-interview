package com.edu.java.linkedlist;

public class SortList {

	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(4);
		head.next = new LinkedListNode(10);
		head.next.next = new LinkedListNode(3);
		head.next.next.next = new LinkedListNode(5);
		LinkedListNode newHead = sortList(head);
		System.out.println(newHead);
	}

	private static LinkedListNode sortList(LinkedListNode head) {
		return null;
	}

}
