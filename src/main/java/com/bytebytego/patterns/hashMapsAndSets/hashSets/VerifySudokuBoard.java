package com.bytebytego.patterns.hashMapsAndSets.hashSets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a partially completed 9x9 Sudoku board, determine if the current state of the board adheres to
 * the rules of the game:
 * - Each row and column must contain unique numbers between 1 and 9, or be empty(represented by 0).
 * - Each of the nine 3x3 sub-grids that compose the grid must contain unique numbers between 1 and 9, or be empty.
 * Note: You are asked to determine whether the current state of the board is valid given these rules,
 * not whether the board is solvable.
 */
public class VerifySudokuBoard {

	private static final int SIZE = 9;
	private static final int SUBGRID_SIZE = 3;

	public static boolean verifySudokuBoard(int[][] board) {
		// Create hash sets for each row, column, and subgrid to keep
		// track of numbers previously seen on any given row, column, or subgrid.
		List<Set<Integer>> rowSets = new ArrayList<>(SIZE);
		List<Set<Integer>> columnSets = new ArrayList<>(SIZE);
		List<List<Set<Integer>>> subgridSets = new ArrayList<>(SIZE);

		for (int i = 0; i < SIZE; i++) {
			rowSets.add(new HashSet<>());
			columnSets.add(new HashSet<>());
		}

		for (int i = 0; i < SUBGRID_SIZE; i++) {
			List<Set<Integer>> subgridRow = new ArrayList<>(SUBGRID_SIZE);
			for (int j = 0; j < SUBGRID_SIZE; j++) {
				subgridRow.add(new HashSet<>());
			}
			subgridSets.add(subgridRow);
		}

		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				int num = board[r][c];
				if (num == 0) {
					continue;
				}

				// Check if 'num' has been seen in the current row, column, or subgrid
				if (rowSets.get(r).contains(num)) {
					return false;
				}
				if (columnSets.get(c).contains(num)) {
					return false;
				}
				if (subgridSets.get(r / SUBGRID_SIZE).get(c / SUBGRID_SIZE).contains(num)) {
					return false;
				}

				// If we passed the above checks, mark this value as seen by
				// adding it to it's corresponding hash sets
				rowSets.get(r).add(num);
				columnSets.get(c).add(num);
				subgridSets.get(r / SUBGRID_SIZE).get(c / SUBGRID_SIZE).add(num);
			}
		}
		return true;
	}

}
