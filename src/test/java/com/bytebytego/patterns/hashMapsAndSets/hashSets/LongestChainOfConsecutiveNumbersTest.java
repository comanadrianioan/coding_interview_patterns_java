package com.bytebytego.patterns.hashMapsAndSets.hashSets;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LongestChainOfConsecutiveNumbersTest {


	@DisplayName("Longest Chain of Consecutive Numbers")
	@ParameterizedTest(name = "Input nums {0} should return {1}")
	@MethodSource("longestChainOfConsecutiveNumbersTestCases")
	void longestChainOfConsecutiveNumbers(int[] nums, int expectedResult) {
		assertEquals(expectedResult, LongestChainOfConsecutiveNumbers.longestChainOfConsecutiveNumbers(nums));
	}

	public static Stream<Arguments> longestChainOfConsecutiveNumbersTestCases() {
		return Stream.of(
				Arguments.of(new int[]{6, 2, 5, 8, 7, 10, 3}, 4),
				Arguments.of(new int[]{100, 4, 200, 1, 3, 2}, 4),
				Arguments.of(new int[]{1, 2, 0, 1}, 3),
				Arguments.of(new int[]{10}, 1),
				Arguments.of(new int[]{10, 30, 20}, 1),
				Arguments.of(new int[]{5, 6, 7, 8, 9}, 5),
				Arguments.of(new int[]{1, 2, 2, 3}, 3),
				Arguments.of(new int[]{-1, -2, -3, -4, 0, 2, 1}, 7),
				Arguments.of(new int[]{1, 9, 3, 10, 2, 20}, 3),
				Arguments.of(new int[]{}, 0),
				Arguments.of(new int[]{1, 3, 5, 2, 4, 6, 8, 10, 9, 7}, 10)
		);
	}
}