package com.edu.java.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PalindromeLinkedList {

	private static final Logger LOGGER = LoggerFactory.getLogger(PalindromeLinkedList.class);

	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(4);
		head.next = new LinkedListNode(10);
		head.next.next = new LinkedListNode(3);
		head.next.next.next = new LinkedListNode(3);
		head.next.next.next.next = new LinkedListNode(10);
		head.next.next.next.next.next = new LinkedListNode(4);
		boolean result = isPalindrome(head);
		LOGGER.info("Is Linked List Palindrome {}", result);
	}

	private static boolean isPalindrome(LinkedListNode head) {
		int length = lengthOfPalindrome(head);
		int mid = (length + 1) / 2;
		LinkedListNode startNode = null;
		LinkedListNode curr = head;
		for (int i = 0; i <= mid && null != curr; i++) {
			if (i == mid) {
				startNode = curr;
			}
			curr = curr.next;
		}

		LinkedListNode newHead = reverseList(startNode);

		LinkedListNode list1 = head;
		LinkedListNode list2 = newHead;
		while (null != list1 && null != list2) {
			if (list1.data != list2.data) {
				return false;
			}
			list1 = list1.next;
			list2 = list2.next;
		}
		return true;
	}

	private static LinkedListNode reverseList(LinkedListNode head) {
		LinkedListNode prev = null;
		LinkedListNode curr = head;
		while (null != curr) {
			LinkedListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static int lengthOfPalindrome(LinkedListNode head) {
		int length = 0;
		LinkedListNode curr = head;
		while (null != curr) {
			length++;
			curr = curr.next;
		}
		return length;
	}

}
