package com.bytebytego.patterns.linkedLists.traversal;

import com.bytebytego.patterns.linkedLists.ListNode;

public class LinkedListIntersection {

	public static ListNode linkedListIntersection(ListNode headA, ListNode headB) {
		ListNode ptrA = headA;
		ListNode ptrB = headB;
		// Traverse through list A with 'ptrA' and list B with 'ptrB'
		// until they meet.
		while (ptrA != ptrB) {
			// Traverse list A -> list B by first traversing 'ptrA' and
			// then, upon reaching the end of list A, continue the
			// traversal from the head of list B.
			ptrA = ptrA == null ? headB : ptrA.getNext();
			// Simultaneously, traverse list B -> list A.
			ptrB = ptrB == null ? headA : ptrB.getNext();
		}
		// At this point, 'ptrA' and 'ptrB' either point to the
		// intersection node or both are null if the lists do not
		// intersect. Return either pointer.
		return ptrA;
	}
}
