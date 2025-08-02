package com.bytebytego.patterns.linkedLists.restructuring;

import com.bytebytego.patterns.linkedLists.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveKthLastNodeTest {

	@DisplayName("Remove K^th Last Node")
	@ParameterizedTest(name = "Test Case #{index}")
	@MethodSource("removeKthLastNodeCases")
	void removeKthLastNode(ListNode input, int k, ListNode expected) {
		ListNode result = RemoveKthLastNode.removeKthLastNode(input, k);
		assertEquals(expected, result);
	}

	static Stream<Arguments> removeKthLastNodeCases() {
		return Stream.of(
			Arguments.of(
				ListNode.of(1, 2, 4, 7, 3),
				2,
				ListNode.of(1, 2, 4, 3)
			),
			Arguments.of(
				ListNode.of(1, 2),
				2,
				ListNode.of(2)
			),
			Arguments.of(
				ListNode.of(1, 2, 3),
				5,
				ListNode.of(1, 2, 3)
			),
			Arguments.of(
				null,
				1,
				null
			),
			Arguments.of(
				ListNode.of(1, 2, 3, 4, 5, 6),
				2,
				ListNode.of(1, 2, 3, 4, 6)
			)
		);
	}
}