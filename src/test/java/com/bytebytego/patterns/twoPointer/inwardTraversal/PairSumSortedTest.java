package com.bytebytego.patterns.twoPointer.inwardTraversal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PairSumSortedTest {

	@DisplayName("Pair Sum - Sorted")
	@ParameterizedTest(name = "Input List ={0}, Target={1}, Expected Result={2}")
	@MethodSource("pairSumTestCases")
	void pairSumSorted(List<Integer> nums, int target, List<Integer> expectedResult) {
		assertEquals(expectedResult, (PairSumSorted.pairSumSorted(nums, target)));
	}

	public static Stream<Arguments> pairSumTestCases() {
		return Stream.of(
				Arguments.of(List.of(), 0, List.of()),
				Arguments.of(List.of(1), 1, List.of()),
				Arguments.of(List.of(2, 3), 5, List.of(0, 1)),
				Arguments.of(List.of(2, 4), 5, List.of()),
				Arguments.of(List.of(2, 2, 3), 5, List.of(0, 2)),
				Arguments.of(List.of(-1, 2, 3), 2, List.of(0, 2)),
				Arguments.of(List.of(-3, -2, -1), -5, List.of(0, 1))
		);
	}
}