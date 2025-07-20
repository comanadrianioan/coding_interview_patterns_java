package com.bytebytego.patterns.twoPointer.inwardTraversal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TripletSumTest {

	@DisplayName("Triple Sum")
	@ParameterizedTest(name = "Input List ={0}, Expected Result={1}")
	@MethodSource("tripletSumTestCases")
	void pairSumSorted(List<Integer> nums, List<List<Integer>> expectedResult) {
		assertEquals(expectedResult, TripletSum.tripletSum(nums));
	}

	public static Stream<Arguments> tripletSumTestCases() {
		return Stream.of(
				Arguments.of(List.of(), List.of()),
				Arguments.of(List.of(0), List.of()),
				Arguments.of(List.of(1, -1), List.of()),
				Arguments.of(List.of(0, 0, 0), List.of(List.of(0, 0, 0))),
				Arguments.of(List.of(1, 0, 1), List.of()),
				Arguments.of(List.of(0, 0, 1, -1, 1, -1), List.of(List.of(-1, 0, 1))),
				Arguments.of(List.of(0, -1, 2, -3, 1), List.of(List.of(-3, 1, 2), List.of(-1, 0, 1)))
		);
	}
}