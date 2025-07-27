package com.bytebytego.patterns.hashMapsAndSets.hashMaps;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GeometricSequenceTripletsTest {


	@DisplayName("Geometric Sequence Triplets")
	@ParameterizedTest(name = "Input nums {0} and common ratio {1} should return {2}")
	@MethodSource("geometricSequenceTripletsTestCases")
	void geometricSequenceTriplets(int[] nums, int commonRatio, int expectedResult) {
		assertEquals(expectedResult, GeometricSequenceTriplets.geometricSequenceTriplets(nums, commonRatio));
	}


	private static Stream<Arguments> geometricSequenceTripletsTestCases() {
		return Stream.of(
				Arguments.of(new int[]{1, 2, 2, 4}, 2, 2),
				Arguments.of(new int[]{1, 3, 9, 9, 27, 81}, 3, 6),
				Arguments.of(new int[]{1, 5, 5, 25, 125}, 5, 4),
				Arguments.of(new int[]{1, 2, 3, 4, 5}, 2, 1),
				Arguments.of(new int[]{1, 1, 1, 1}, 1, 4),
				Arguments.of(new int[]{}, 2, 0),
				Arguments.of(new int[]{1}, 2, 0),
				Arguments.of(new int[]{1, 1, 1}, 1, 1),
				Arguments.of(new int[]{0, 0, 0, 0}, 0, 0),
				Arguments.of(new int[]{2, 4, 8, 16}, 2, 2),
				Arguments.of(new int[]{-1, -3, -9, -27}, 3, 2)
		);
	}
}