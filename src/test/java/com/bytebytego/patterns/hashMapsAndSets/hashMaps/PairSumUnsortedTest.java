package com.bytebytego.patterns.hashMapsAndSets.hashMaps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PairSumUnsortedTest {
	
	@DisplayName("Pair Sum - Unsorted")
	@ParameterizedTest(name = "Input nums {0} and target {1} should return {2}")
	@MethodSource("pairSumUnsortedTestCases")
	void pairSumUnsorted(List<Integer> nums, int target, List<Integer> expectedResult) {
		assertEquals(expectedResult, (PairSumUnsorted.pairSumUnsorted(nums, target)));
	}

	private static Stream<Arguments> pairSumUnsortedTestCases() {
		return Stream.of(
				Arguments.of(List.of(), 0, List.of()),
				Arguments.of(List.of(1), 1, List.of()),
				Arguments.of(List.of(2, 3), 5, List.of(0, 1)),
				Arguments.of(List.of(2, 4), 5, List.of()),
				Arguments.of(List.of(2, 2, 3), 5, List.of(1, 2)),
				Arguments.of(List.of(-1, 2, 3), 2, List.of(0, 2)),
				Arguments.of(List.of(-3, -2, -1), -5, List.of(0, 1))
		);
	}
}
