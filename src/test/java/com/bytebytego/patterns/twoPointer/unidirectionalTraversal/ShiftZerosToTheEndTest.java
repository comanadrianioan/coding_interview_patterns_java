package com.bytebytego.patterns.twoPointer.unidirectionalTraversal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ShiftZerosToTheEndTest {

	@DisplayName("Shift Zeros To The End")
	@ParameterizedTest(name = "Input {0}, expected max water {1}")
	@MethodSource("shiftZerosToTheEndTestCases")
	void shiftZerosToTheEnd(int[] nums, int[] tagetNums) {
		int[] output = ShiftZerosToTheEnd.shiftZerosToTheEnd(nums);
		assertEquals(tagetNums.length, output.length);

		for (int i = 0; i < output.length; i++) {
			assertEquals(tagetNums[i], output[i]);
		}
	}

	public static Stream<Arguments> shiftZerosToTheEndTestCases() {
		return Stream.of(
				Arguments.of(new int[]{}, new int[]{}),
				Arguments.of(new int[]{0}, new int[]{0}),
				Arguments.of(new int[]{1}, new int[]{1}),
				Arguments.of(new int[]{0, 0, 0}, new int[]{0, 0, 0}),
				Arguments.of(new int[]{1, 3, 2}, new int[]{1, 3, 2}),
				Arguments.of(new int[]{1, 1, 1, 0, 0}, new int[]{1, 1, 1, 0, 0}),
				Arguments.of(new int[]{0, 0, 1, 1, 1}, new int[]{1, 1, 1, 0, 0}),
				Arguments.of(new int[]{0, 1, 0, 3, 2}, new int[]{1, 3, 2, 0, 0})
		);
	}
}