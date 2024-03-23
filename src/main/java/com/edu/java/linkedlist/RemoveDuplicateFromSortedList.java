package com.edu.java.linkedlist;

public class RemoveDuplicateFromSortedList {

	public static void main(String[] args) {
		Integer[] nums = new Integer[] { 1, 1, 1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8, 9, 9 };
		LinkedListNode head = LinkedListUtil.createLinkedList(nums);
		LinkedListUtil.printLinkedList(head);
		LinkedListNode result = removeDuplicates(head);
		LinkedListUtil.printLinkedList(result);
	}

	private static LinkedListNode removeDuplicates(LinkedListNode head) {
		if (null == head)
			return head;
		LinkedListNode newHead = head;
		LinkedListNode prevNode = head;
		LinkedListNode currNode = head.next;
		prevNode.next = null;
		while (null != currNode) {
			int prevData = prevNode.data;
			int currData = currNode.data;
			if (prevData != currData) {
				prevNode.next = currNode;
				prevNode = currNode;
			}
			currNode = currNode.next;
			prevNode.next = null;
		}
		return newHead;
	}

}
