package com.bytebytego.patterns.linkedLists.restructuring;

import com.bytebytego.patterns.linkedLists.MultiLevelListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FlattenMultiLevelLinkedListTest {

	@DisplayName("Flatten Multi-Level List")
	@ParameterizedTest(name = "Test Case #{index}")
	@MethodSource("flattenMultiLevelListTestCases")
	void flattenMultiLevelList(MultiLevelListNode input, int[] expected) {
		MultiLevelListNode result = FlattenMultiLevelLinkedList.flattenMultiLevelList(input);
		
		if (expected == null) {
			assertNull(result);
		} else {
			assertNotNull(result);
			int[] actual = listToArray(result);
			assertArrayEquals(expected, actual, "Flattened list should match expected array");
		}
	}

	static Stream<Object[]> flattenMultiLevelListTestCases() {
		return Stream.of(
			new Object[]{
				null,
				null
			},
			new Object[]{
				new MultiLevelListNode(1),
				new int[]{1}
			},
			new Object[]{
				createSimpleList(),
				new int[]{1, 2, 3}
			},
			new Object[]{
				createComplexExample(),
				new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
			}
		);
	}

	private static MultiLevelListNode createSimpleList() {
		MultiLevelListNode node3 = new MultiLevelListNode(3);
		MultiLevelListNode node1 = new MultiLevelListNode(1, node3);
		MultiLevelListNode node2 = new MultiLevelListNode(2);
		node1.setNext(node2);
		return node1;
	}
	
	private static MultiLevelListNode createComplexExample() {
		MultiLevelListNode node1 = new MultiLevelListNode(1);
		MultiLevelListNode node5 = new MultiLevelListNode(5);
		MultiLevelListNode node6 = new MultiLevelListNode(6);
		MultiLevelListNode node9 = new MultiLevelListNode(9);
		node6.setChild(node9);
		node5.setNext(node6);
		node1.setChild(node5);

		MultiLevelListNode node2 = new MultiLevelListNode(2);
		MultiLevelListNode node3 = new MultiLevelListNode(3);
		MultiLevelListNode node4 = new MultiLevelListNode(4);
		MultiLevelListNode node7 = new MultiLevelListNode(7);
		MultiLevelListNode node8 = new MultiLevelListNode(8);
		MultiLevelListNode node10 = new MultiLevelListNode(10);
		node4.setChild(node7);
		node7.setChild(node10);

		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node7.setNext(node8);
		
		return node1;
	}
	
	private static int[] listToArray(MultiLevelListNode head) {
		if (head == null) return new int[0];
		
		int count = 0;
		MultiLevelListNode current = head;
		while (current != null) {
			count++;
			current = (MultiLevelListNode) current.getNext();
		}
		
		int[] array = new int[count];
		current = head;
		int index = 0;
		while (current != null) {
			array[index++] = current.getVal();
			current = (MultiLevelListNode) current.getNext();
		}
		
		return array;
	}
}