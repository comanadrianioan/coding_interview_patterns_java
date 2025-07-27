package com.bytebytego.patterns.linkedLists;

public class ListNode {
	private int val;
	private ListNode next;

	public ListNode(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public static ListNode of(int... values) {
		if (values.length == 0) return null;

		ListNode head = new ListNode(values[0]);
		ListNode current = head;
		for (int i = 1; i < values.length; i++) {
			current.setNext(new ListNode(values[i]));
			current = current.getNext();
		}

		return head;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ListNode b)) return false;
		ListNode a = this;
		while (a != null && b != null) {
			if (a.val != b.val) return false;
			a = a.next;
			b = b.next;
		}
		return a == null && b == null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode curr = this;
		while (curr != null) {
			sb.append(curr.val);
			if (curr.next != null) sb.append(" -> ");
			curr = curr.next;
		}
		return sb.toString();
	}
}
