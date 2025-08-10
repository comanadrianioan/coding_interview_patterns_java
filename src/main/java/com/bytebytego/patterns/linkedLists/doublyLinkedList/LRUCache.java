package com.bytebytego.patterns.linkedLists.doublyLinkedList;

import java.util.HashMap;
import java.util.Map;

import com.bytebytego.patterns.linkedLists.DoublyLinkedListNode;

/**
 * Design and implement a data structure for the Least Recently Used (LRU) cache that supports
 * the following operations:
 *
 * -> LRUCache(int capacity) : initialize an LRU Cache with the specified capacity.
 * -> get(int key): return the value associated with a key. Returns -1 if the key doesn't exist.
 * -> put(int key, int value): add a key and its value to the cache. If adding the key would result
 *                              in the cache exceeding its size capacity, evict the least recently used element.
 *                              If the key already exists in the cache, update its value.
 */
public class LRUCache {
	private final int capacity;
	private final Map<Integer, DoublyLinkedListNode> keysAndValues;
	private final DoublyLinkedListNode head = new DoublyLinkedListNode(-1, -1);
	private final DoublyLinkedListNode tail = new DoublyLinkedListNode(-1, -1);

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.keysAndValues = new HashMap<>();
		this.head.setNext(this.tail);
		this.tail.setPrev(this.head);
	}

	public int get(int key) {
		if(!keysAndValues.containsKey(key)) {
			return -1;
		}

		removeNode(keysAndValues.get(key));
		addToTail(keysAndValues.get(key));
		return keysAndValues.get(key).getValue();
	}

	public void put(int key, int value) {
		if(keysAndValues.containsKey(key)) {
			removeNode(keysAndValues.get(key));
		}

		DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
		keysAndValues.put(key, node);
		if(keysAndValues.size() > capacity) {
			keysAndValues.remove(head.getNext().getKey());
			removeNode(head.getNext());
		}
		addToTail(node);
	}

	private void addToTail(DoublyLinkedListNode node) {
		DoublyLinkedListNode prevNode = tail.getPrev();
		node.setPrev(prevNode);
		node.setNext(tail);
		prevNode.setNext(node);
		tail.setPrev(node);
	}

	private void removeNode(DoublyLinkedListNode node) {
		node.getPrev().setNext(node.getNext());
		node.getNext().setPrev(node.getPrev());
	}
}
