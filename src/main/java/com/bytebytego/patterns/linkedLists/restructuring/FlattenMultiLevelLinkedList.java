package com.bytebytego.patterns.linkedLists.restructuring;

import com.bytebytego.patterns.linkedLists.MultiLevelListNode;

/**
 * In a multi-level linked list, each node has a next pointer and child pointer. The next pointer connects to the
 * same linked list, while the child pointer points to the head of a new linked list under it. This creates multiple levels
 * of linked lists. If a node does have a child attribute is set to null.
 * <p>
 * Flatten the multi-level linked list into a single-level linked list by linking the end of each level to the start
 * of the next one.
 */
public class FlattenMultiLevelLinkedList {
	
	/**
	 * Time complexity: O(n)
	 */
	public static MultiLevelListNode flattenMultiLevelList(MultiLevelListNode head) {
		if (head == null) {
			return null;
		}

		MultiLevelListNode tail = head;
		while (tail.getNext() != null) {
			tail = (MultiLevelListNode) tail.getNext();
		}

		MultiLevelListNode current = head;
		while (current != null) {
			if (current.getChild() != null) {
				tail.setNext(current.getChild());
				current.setChild(null);
				while (tail.getNext() != null) {
					tail = (MultiLevelListNode) tail.getNext();
				}
			}
			current = (MultiLevelListNode) current.getNext();
		}

		return head;
	}

}