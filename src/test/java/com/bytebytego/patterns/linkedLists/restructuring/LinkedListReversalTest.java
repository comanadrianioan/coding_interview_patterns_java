package com.bytebytego.patterns.linkedLists.restructuring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.bytebytego.patterns.linkedLists.ListNode;

class LinkedListReversalTest {

	@DisplayName("Linked List Reversal")
	@ParameterizedTest(name = "Test Case #{index}")
	@MethodSource("linkedListReversalTestCases")
	void linkedListReversal(ListNode head, ListNode expected) {
		assertEquals(expected, LinkedListReversal.linkedListReversal(head));
	}

	@DisplayName("Linked List Reversal - Recursive")
	@ParameterizedTest(name = "Test Case #{index}")
	@MethodSource("linkedListReversalTestCases")
	void linkedListReversalRecursive(ListNode head, ListNode expected) {
		assertEquals(expected, LinkedListReversal.linkedListReversalRecursive(head));
	}

	public static Stream<Arguments> linkedListReversalTestCases() {
		return Stream.of(
				Arguments.of(null, null),
				Arguments.of(
						ListNode.of(1),
						ListNode.of(1)
				),
				Arguments.of(
						ListNode.of(1, 2),
						ListNode.of(2, 1)
				),
				Arguments.of(
						ListNode.of(1, 2, 3),
						ListNode.of(3, 2, 1)
				),
				Arguments.of(
						ListNode.of(10, 20, 30, 40, 50),
						ListNode.of(50, 40, 30, 20, 10)
				)
		);
	}
}
