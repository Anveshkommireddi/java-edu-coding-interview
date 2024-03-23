package com.edu.java.linkedlist;

public class LinkedListUtil {

	public static LinkedListNode createLinkedList(Integer... data) {
		LinkedListNode head = null;
		LinkedListNode prev = head;
		for (Integer num : data) {
			LinkedListNode curr = new LinkedListNode(num);
			if (null == head) {
				head = curr;
				prev = head;
			} else {
				prev.next = curr;
				prev = curr;
			}
		}
		return head;
	}

	public static void printLinkedList(LinkedListNode head) {
		LinkedListNode curr = head;
		StringBuilder sb = new StringBuilder();
		while (null != curr && null != curr.next) {
			sb.append(curr.data).append(" --> ");
			curr = curr.next;
		}
		if (null != curr) {
			sb.append(curr.data);
		}
		System.out.println(sb.toString());
	}

}
