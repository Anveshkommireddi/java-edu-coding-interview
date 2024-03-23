package com.edu.java.linkedlist;

public class AddTwoNumbers {

	public static void main(String[] args) {
		
		LinkedListNode head = new LinkedListNode(2);
		head.next = new LinkedListNode(4);
		head.next.next = new LinkedListNode(3);

		LinkedListNode head1 = new LinkedListNode(5);
		head1.next = new LinkedListNode(6);
		head1.next.next = new LinkedListNode(4);
		
		LinkedListNode result = addTwoNumbers(head, head1);
		
		System.out.println(result);
	}

	private static LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
		LinkedListNode result = new LinkedListNode(0);
		LinkedListNode curr1 = l1;
        LinkedListNode curr2 = l2;
        int carry = 0;
        LinkedListNode currNode = result;
        while(null != curr1 || null != curr2 || carry != 0) {
          int val1 = null == curr1 ? 0 : curr1.data;
          int val2 = null == curr2 ? 0 : curr2.data;
          int sum = val1 + val2 + carry;
          carry = sum / 10;
          int nodeVal = sum % 10;
          LinkedListNode sumNode = new LinkedListNode(nodeVal);
          currNode.next = sumNode;
          if(null != curr1) {
            curr1 = curr1.next;
          }

          if(null != curr2) {
            curr2 = curr2.next;
          }
          currNode = currNode.next; 
        }
        return result.next;
	}

}
