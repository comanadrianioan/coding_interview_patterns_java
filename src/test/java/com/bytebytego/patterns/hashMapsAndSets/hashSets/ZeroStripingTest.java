package com.bytebytego.patterns.hashMapsAndSets.hashSets;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ZeroStripingTest {

	@DisplayName("Zero Striping - Hash Set")
	@ParameterizedTest(name = "Test Case #{index}")
	@MethodSource("zeroStripingTestCases")
	void zeroStripingHashSet(int[][] matrix, int[][] expectedOutput) {
		ZeroStriping.zeroStripingHashSet(matrix);
		for (int i = 0; i < matrix.length; i++) {
			assertArrayEquals(expectedOutput[i], matrix[i], "Mismatch in row " + i);
		}
	}

	@DisplayName("Zero Striping")
	@ParameterizedTest(name = "Test Case #{index}")
	@MethodSource("zeroStripingTestCases")
	void zeroStriping(int[][] matrix, int[][] expectedOutput) {
		ZeroStriping.zeroStriping(matrix);
		for (int i = 0; i < matrix.length; i++) {
			assertArrayEquals(expectedOutput[i], matrix[i], "Mismatch in row " + i);
		}
	}

	private static Stream<Arguments> zeroStripingTestCases() {
		return Stream.of(
				// ✅ Test case 1: single zero in middle of matrix
				Arguments.of(
						new int[][]{
								{1, 2, 3},
								{4, 0, 6},
								{7, 8, 9}
						},
						new int[][]{
								{1, 0, 3},
								{0, 0, 0},
								{7, 0, 9}
						}
				),

				// ✅ Test case 2: multiple zeros
				Arguments.of(
						new int[][]{
								{1, 2, 0},
								{4, 5, 6},
								{0, 8, 9}
						},
						new int[][]{
								{0, 0, 0},
								{0, 5, 0},
								{0, 0, 0}
						}
				),

				// ✅ Test case 3: zero in corner
				Arguments.of(
						new int[][]{
								{0, 2},
								{3, 4}
						},
						new int[][]{
								{0, 0},
								{0, 4}
						}
				),

				// ✅ Test case 4: no zeroes
				Arguments.of(
						new int[][]{
								{1, 2},
								{3, 4}
						},
						new int[][]{
								{1, 2},
								{3, 4}
						}
				),

				// ✅ Test case 5: all zeroes
				Arguments.of(
						new int[][]{
								{0, 0},
								{0, 0}
						},
						new int[][]{
								{0, 0},
								{0, 0}
						}
				),

				// ✅ Test case 6: original example
				Arguments.of(
						new int[][]{
								{1, 2, 3, 4, 5},
								{6, 0, 8, 9, 1},
								{11, 12, 13, 14, 15},
								{16, 17, 18, 19, 0}
						},
						new int[][]{
								{1, 0, 3, 4, 0},
								{0, 0, 0, 0, 0},
								{11, 0, 13, 14, 0},
								{0, 0, 0, 0, 0}
						}
				)
		);
	}
}