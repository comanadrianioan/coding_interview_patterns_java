package com.bytebytego.patterns.hashMapsAndSets.hashSets;

import java.util.HashSet;

/**
 * For each zero in M x N matrix, set its entire row and column to zero in place.
 */
public class ZeroStriping {

	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{1, 2, 3, 4, 5},
				{6, 0, 8, 9, 1},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 0}
		};

		zeroStriping(matrix);

		for (int[] ints : matrix) {
			for (int column = 0; column < matrix[0].length; column++) {
				System.out.print(ints[column] + " ");
			}
			System.out.println();
		}
	}

	public static void zeroStripingHashSet(int[][] matrix) {
		HashSet<Integer> zeroRows = new HashSet<>();
		HashSet<Integer> zeroColumns = new HashSet<>();
		int n = matrix.length;
		int m = matrix[0].length;

		for (int row = 0; row < n; row++) {
			for (int column = 0; column < m; column++) {
				if (matrix[row][column] == 0) {
					zeroRows.add(row);
					zeroColumns.add(column);
				}
			}
		}

		for (int row = 0; row < n; row++) {
			for (int column = 0; column < m; column++) {
				if (zeroRows.contains(row) || zeroColumns.contains(column)) {
					matrix[row][column] = 0;
				}
			}
		}
	}

	public static void zeroStriping(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		// Check if the first row initially contains a zero
		boolean firstRowHasZero = false;
		for (int column = 0; column < m; column++) {
			if (matrix[0][column] == 0) {
				firstRowHasZero = true;
				break;
			}
		}

		// Check if the first column initially contains a zero
		boolean firstColHasZero = false;
		for (int row = 0; row < n; row++) {
			if (matrix[row][0] == 0) {
				firstColHasZero = true;
				break;
			}
		}

		// Use the first row and column as markers. If an element in the submatrix is zero, mark
		// its corresponding row and column in the first row and column as 0
		for (int row = 0; row < n; row++) {
			for (int column = 0; column < m; column++) {
				if (matrix[row][column] == 0) {
					matrix[0][column] = 0;
					matrix[row][0] = 0;
				}
			}
		}

		// Update the submatrix using the markers in the first row and column
		for (int row = 1; row < n; row++) {
			for (int column = 1; column < m; column++) {
				if (matrix[0][column] == 0 || matrix[row][0] == 0) {
					matrix[row][column] = 0;
				}
			}
		}

		//If the first row had a zero initially, set all the elements in the first row to zero
		if (firstRowHasZero) {
			for (int column = 0; column < m; column++) {
				matrix[0][column] = 0;
			}
		}

		//If the first column had a zero initially, set all the elements in the first column to zero
		if (firstColHasZero) {
			for (int row = 0; row < n; row++) {
				matrix[row][0] = 0;
			}
		}
	}
}
