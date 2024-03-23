package com.edu.java.linkedlist;

public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {

		LinkedListNode head = new LinkedListNode(2);
		head.next = new LinkedListNode(4);
		head.next.next = new LinkedListNode(3);

		LinkedListNode head1 = new LinkedListNode(5);
		head1.next = new LinkedListNode(6);
		head1.next.next = new LinkedListNode(4);

	}

	public LinkedListNode getIntersectionNode(LinkedListNode headA, LinkedListNode headB) {
		int l1 = length(headA);
		int l2 = length(headB);
		LinkedListNode curr1 = headA;
		LinkedListNode curr2 = headB;
		if (l1 < l2) {
			int diff = l2 - l1;
			for (int i = 0; i < diff && null != curr2; i++) {
				curr2 = curr2.next;
			}
		} else if (l2 < l1) {
			int diff = l1 - l2;
			for (int i = 0; i < diff && null != curr1; i++) {
				curr1 = curr1.next;
			}
		}

		while (null != curr1 && null != curr2) {
			if (curr1 == curr2)
				return curr1;
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		return null;
	}

	private static int length(LinkedListNode head) {
		LinkedListNode curr = head;
		int length = 0;
		while (null != curr) {
			curr = curr.next;
			length++;
		}
		return length;
	}

}
