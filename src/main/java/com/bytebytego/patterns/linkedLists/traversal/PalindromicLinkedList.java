package com.bytebytego.patterns.linkedLists.traversal;

import static com.bytebytego.patterns.linkedLists.restructuring.LinkedListReversal.linkedListReversal;

import com.bytebytego.patterns.linkedLists.ListNode;

/**
 * Given the head of a singly linked list, determine if it is a palindrome.
 */
public class PalindromicLinkedList {

	public static boolean palindromicLinkedList(ListNode head) {
		ListNode mid = findMiddle(head);
		ListNode secondHead = linkedListReversal(mid);

		ListNode ptr1 = head;
		ListNode ptr2 = secondHead;
		boolean res = true;

		while(ptr2 != null) {
			if(ptr2.getVal() != ptr1.getVal()) {
				return false;
			}
			ptr1 = ptr1.getNext();
			ptr2 = ptr2.getNext();
		}
		return res;
	}

	// From the 'Linked List Midpoint' problem.
	// TODO:: replace once I implement the problem.
	private static ListNode findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while(fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}

		return slow;
	}

}
