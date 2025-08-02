package com.bytebytego.patterns.linkedLists;

public class MultiLevelListNode extends ListNode {
	private ListNode child;

	public MultiLevelListNode(int val) {
		super(val);
	}

	public MultiLevelListNode(int val, ListNode child) {
		super(val);
		this.child = child;
	}

	public ListNode getChild() {
		return child;
	}

	public void setChild(ListNode child) {
		this.child = child;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		MultiLevelListNode curr = this;

		while (curr != null) {
			sb.append(curr.getVal());

			// Add child information if present
			if (curr.child != null) {
				sb.append(" [child: ").append(curr.child).append("]");
			}

			if (curr.getNext() != null) {
				sb.append(" -> ");
			}

			curr = (MultiLevelListNode) curr.getNext();
		}

		return sb.toString();
	}
}