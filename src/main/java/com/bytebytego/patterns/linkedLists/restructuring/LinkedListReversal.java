package com.bytebytego.patterns.linkedLists.restructuring;


import com.bytebytego.patterns.linkedLists.ListNode;

/**
 * Reverse a singly linked list.
 */
public class LinkedListReversal {

	public static ListNode linkedListReversal(ListNode head) {
		ListNode currNode = head;
		ListNode prevNode = null;

		while(currNode != null) {
			ListNode nextNode = currNode.getNext();
			currNode.setNext(prevNode);
			prevNode = currNode;
			currNode = nextNode;
		}

		return prevNode;
	}

	public static ListNode linkedListReversalRecursive(ListNode head) {
		if(head == null || head.getNext() == null) {
			return head;
		}

		ListNode newHead = linkedListReversalRecursive(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);

		return newHead;
	}

}
