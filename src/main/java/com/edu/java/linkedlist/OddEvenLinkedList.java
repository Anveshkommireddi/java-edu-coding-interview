package com.edu.java.linkedlist;

public class OddEvenLinkedList {

	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(1);
		head.next = new LinkedListNode(2);
		head.next.next = new LinkedListNode(3);
		head.next.next.next = new LinkedListNode(4);
		head.next.next.next.next = new LinkedListNode(5);
		head.next.next.next.next.next = new LinkedListNode(6);
		LinkedListNode newHead = oddEvenLinkedList(head);
		System.out.println(newHead);
	}

	private static LinkedListNode oddEvenLinkedList(LinkedListNode head) {

		LinkedListNode evenDummy = new LinkedListNode(0);
		LinkedListNode oddDummy = new LinkedListNode(0);

		LinkedListNode evenCurrent = evenDummy;
		LinkedListNode oddCurrent = oddDummy;
		LinkedListNode curr = head;
		int index = 1;
		while (null != curr) {
			if (index % 2 == 1) {
				oddCurrent.next = curr;
				oddCurrent = oddCurrent.next;
			} else {
				evenCurrent.next = curr;
				evenCurrent = evenCurrent.next;
			}
			curr = curr.next;
			index++;
		}
		oddCurrent.next = evenDummy.next;
		evenCurrent.next = null;
		return oddDummy.next;
	}
}
