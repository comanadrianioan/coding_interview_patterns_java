package com.bytebytego.patterns.twoPointer.inwardTraversal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LargestContainerTest {

	@DisplayName("Largest Container")
	@ParameterizedTest(name = "Input {0}, expected max water {1}")
	@MethodSource("largestContainerTestCases")
	void largestContainer(List<Integer> input, int expectedResult) {
		assertEquals(expectedResult, LargestContainer.largestContainer(input));
	}

	private static Stream<Arguments> largestContainerTestCases() {
		return Stream.of(
				Arguments.of(List.of(), 0),
				Arguments.of(List.of(1), 0),
				Arguments.of(List.of(0, 1, 0), 0),
				Arguments.of(List.of(3, 3, 3, 3), 9),
				Arguments.of(List.of(1, 2, 3), 2),
				Arguments.of(List.of(3, 2, 1), 2),
				Arguments.of(List.of(2, 7, 8, 3, 7, 6), 24)
		);
	}
}