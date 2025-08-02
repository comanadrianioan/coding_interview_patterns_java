package com.bytebytego.patterns.linkedLists.restructuring;

import com.bytebytego.patterns.linkedLists.ListNode;

/**
* Return the head of a singly linked list after removing the k^th node from the end of it.
 */
public class RemoveKthLastNode {

	public static ListNode removeKthLastNode(ListNode head, int k) {
		ListNode dummy = ListNode.of(-1);
		dummy.setNext(head);

		ListNode trailer = dummy, leader = dummy;

		for(int i = 0; i < k; i++) {
			leader = leader.getNext();
			// if K is larger than the length of the linked list,
			// no node needs to be removed.
			if(leader == null) {
				return head;
			}
		}

		while(leader.getNext() != null) {
			leader = leader.getNext();
			trailer = trailer.getNext();
		}

		trailer.setNext(leader);
		return dummy.getNext();
	}
}
