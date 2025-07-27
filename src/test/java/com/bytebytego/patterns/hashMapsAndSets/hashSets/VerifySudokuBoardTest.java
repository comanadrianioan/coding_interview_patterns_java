package com.bytebytego.patterns.hashMapsAndSets.hashSets;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class VerifySudokuBoardTest {


	@DisplayName("Verify Sudoku Board")
	@ParameterizedTest(name = "Given sudoku board should return: {1}")
	@MethodSource("verifySudokuBoardTestCases")
	void verifySudokuBoard(int[][] board, boolean isValid) {
		assertEquals(isValid, VerifySudokuBoard.verifySudokuBoard(board));
	}

	public static Stream<Arguments> verifySudokuBoardTestCases() {
		return Stream.of(
				// ✅ Valid board: Empty board
				Arguments.of(new int[9][9], true),

				// ✅ Valid board: partially filled, no conflicts
				Arguments.of(new int[][]{
						{5, 3, 0, 0, 7, 0, 0, 0, 0},
						{6, 0, 0, 1, 9, 5, 0, 0, 0},
						{0, 9, 8, 0, 0, 0, 0, 6, 0},
						{8, 0, 0, 0, 6, 0, 0, 0, 3},
						{4, 0, 0, 8, 0, 3, 0, 0, 1},
						{7, 0, 0, 0, 2, 0, 0, 0, 6},
						{0, 6, 0, 0, 0, 0, 2, 8, 0},
						{0, 0, 0, 4, 1, 9, 0, 0, 5},
						{0, 0, 0, 0, 8, 0, 0, 7, 9}
				}, true),

				// ❌ Invalid board: duplicate in row
				Arguments.of(new int[][]{
						{5, 3, 5, 0, 7, 0, 0, 0, 0}, // 5 repeated in row 0
						{6, 0, 0, 1, 9, 5, 0, 0, 0},
						{0, 9, 8, 0, 0, 0, 0, 6, 0},
						{8, 0, 0, 0, 6, 0, 0, 0, 3},
						{4, 0, 0, 8, 0, 3, 0, 0, 1},
						{7, 0, 0, 0, 2, 0, 0, 0, 6},
						{0, 6, 0, 0, 0, 0, 2, 8, 0},
						{0, 0, 0, 4, 1, 9, 0, 0, 5},
						{0, 0, 0, 0, 8, 0, 0, 7, 9}
				}, false),

				// ❌ Invalid board: duplicate in column
				Arguments.of(new int[][]{
						{5, 3, 0, 0, 7, 0, 0, 0, 0},
						{6, 0, 0, 1, 9, 5, 0, 0, 0},
						{5, 9, 8, 0, 0, 0, 0, 6, 0}, // 5 repeated in column 0
						{8, 0, 0, 0, 6, 0, 0, 0, 3},
						{4, 0, 0, 8, 0, 3, 0, 0, 1},
						{7, 0, 0, 0, 2, 0, 0, 0, 6},
						{0, 6, 0, 0, 0, 0, 2, 8, 0},
						{0, 0, 0, 4, 1, 9, 0, 0, 5},
						{0, 0, 0, 0, 8, 0, 0, 7, 9}
				}, false),

				// ❌ Invalid board: duplicate in 3x3 subgrid
				Arguments.of(new int[][]{
						{5, 3, 0, 0, 7, 0, 0, 0, 0},
						{6, 5, 0, 1, 9, 5, 0, 0, 0}, // 5 repeated in top-left subgrid
						{0, 9, 8, 0, 0, 0, 0, 6, 0},
						{8, 0, 0, 0, 6, 0, 0, 0, 3},
						{4, 0, 0, 8, 0, 3, 0, 0, 1},
						{7, 0, 0, 0, 2, 0, 0, 0, 6},
						{0, 6, 0, 0, 0, 0, 2, 8, 0},
						{0, 0, 0, 4, 1, 9, 0, 0, 5},
						{0, 0, 0, 0, 8, 0, 0, 7, 9}
				}, false),

				// ✅ Valid board: single digit in correct place
				Arguments.of(new int[][]{
						{0, 0, 0, 0, 0, 0, 0, 0, 1},
						{0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0},
						{1, 0, 0, 0, 0, 0, 0, 0, 0} // No conflict with top right
				}, true)
		);
	}
}