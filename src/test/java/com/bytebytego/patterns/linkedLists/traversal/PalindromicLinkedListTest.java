package com.bytebytego.patterns.linkedLists.traversal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.bytebytego.patterns.linkedLists.ListNode;

class PalindromicLinkedListTest {

	@DisplayName("Palindromic Linked List")
	@ParameterizedTest(name = "Input linked list {0} should return {1}")
	@MethodSource("palindromicLinkedListTestCases")
	void palindromicLinkedList(int[] input, boolean expectedResult) {
		assertEquals(expectedResult, PalindromicLinkedList.palindromicLinkedList(ListNode.of(input)));
	}

	private static Stream<Arguments> palindromicLinkedListTestCases() {
		return Stream.of(
				Arguments.of(new int[]{}, true),
				Arguments.of(new int[]{1}, true),
				Arguments.of(new int[]{1, 1}, true),
				Arguments.of(new int[]{1, 2}, false),
				Arguments.of(new int[]{1, 2, 1}, true),
				Arguments.of(new int[]{1, 2, 2, 1}, true),
				Arguments.of(new int[]{1, 2, 3, 2, 1}, true),
				Arguments.of(new int[]{1, 2, 3, 4, 5}, false),
				Arguments.of(new int[]{1, 2, 3, 3, 2, 1}, true)
		);
	}
}