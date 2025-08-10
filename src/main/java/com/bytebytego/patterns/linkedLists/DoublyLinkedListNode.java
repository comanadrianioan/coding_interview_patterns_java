package com.bytebytego.patterns.linkedLists;

public class DoublyLinkedListNode {
	private int key;
	private int value;
	private DoublyLinkedListNode prev;
	private DoublyLinkedListNode next;

	public DoublyLinkedListNode(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public static DoublyLinkedListNode of(int... values) {
		if (values.length == 0) return null;

		DoublyLinkedListNode head = new DoublyLinkedListNode(0, values[0]);
		DoublyLinkedListNode current = head;
		for (int i = 1; i < values.length; i++) {
			DoublyLinkedListNode newNode = new DoublyLinkedListNode(i, values[i]);
			current.setNext(newNode);
			newNode.setPrev(current);
			current = current.getNext();
		}

		return head;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public DoublyLinkedListNode getPrev() {
		return prev;
	}

	public void setPrev(DoublyLinkedListNode prev) {
		this.prev = prev;
	}

	public DoublyLinkedListNode getNext() {
		return next;
	}

	public void setNext(DoublyLinkedListNode next) {
		this.next = next;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DoublyLinkedListNode b)) return false;

		DoublyLinkedListNode a = this;
		while (a != null && b != null) {
			if (a.key != b.key || a.value != b.value) return false;
			a = a.next;
			b = b.next;
		}

		return a == null && b == null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		DoublyLinkedListNode curr = this;

		while (curr != null) {
			sb.append("[").append(curr.key).append(":").append(curr.value).append("]");
			if (curr.next != null) {
				sb.append(" <-> ");
			}
			curr = curr.next;
		}
		
		return sb.toString();
	}
}
