package com.edu.java.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromUnSortedList {

	public static void main(String[] args) {
		Integer[] nums = new Integer[] { 7, 7, 1, 6, 10, 2, 7, 4, 7, 6 };
		LinkedListNode head = LinkedListUtil.createLinkedList(nums);
		LinkedListUtil.printLinkedList(head);
		LinkedListNode result = removeDuplicates(head);
		LinkedListUtil.printLinkedList(result);
	}

	private static LinkedListNode removeDuplicates(LinkedListNode head) {
		if (null == head)
			return head;
		Set<Integer> nums = new HashSet<>();
		nums.add(head.data);
		LinkedListNode newHead = head;
		LinkedListNode prevNode = head;
		LinkedListNode currNode = head.next;
		newHead.next = null;
		while (null != currNode) {
			int data = currNode.data;
			if (!nums.contains(data)) {
				nums.add(data);
				prevNode.next = currNode;
				prevNode = currNode;
			}
			currNode = currNode.next;
			prevNode.next = null;
		}
		return newHead;
	}

}
