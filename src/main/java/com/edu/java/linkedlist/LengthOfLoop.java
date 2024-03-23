package com.edu.java.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LengthOfLoop {

	private static final Logger LOGGER = LoggerFactory.getLogger(LengthOfLoop.class);

	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(4);
		head.next = new LinkedListNode(10);
		head.next.next = new LinkedListNode(3);
		head.next.next.next = new LinkedListNode(5);
		head.next.next.next.next = head.next;
		int result = lengthOfLoop(head);
		LOGGER.info("Length of the Loop is {}", result);
	}

	private static int lengthOfLoop(LinkedListNode head) {
		LinkedListNode fp = checkIfLoopPresent(head);
		if (fp == null)
			return 0;
		LinkedListNode sp = head;
		LinkedListNode start = getStartOfLoop(sp, fp);
		LinkedListNode curr = start;
		int result = 0;
		while (null != curr) {
			result++;
			curr = curr.next;
			if (curr == start)
				break;
		}
		return result;
	}

	private static LinkedListNode getStartOfLoop(LinkedListNode sp, LinkedListNode fp) {
		while (null != sp && null != fp) {
			if (sp == fp) {
				return sp;
			}
			sp = sp.next;
			fp = fp.next;
		}
		return null;
	}

	private static LinkedListNode checkIfLoopPresent(LinkedListNode head) {
		LinkedListNode fp = head;
		LinkedListNode sp = head;
		while (null != sp && null != fp && null != fp.next) {
			sp = sp.next;
			fp = fp.next.next;
			if (sp == fp) {
				return fp;
			}
		}
		return null;
	}
}
