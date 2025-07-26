package com.bytebytego.patterns.twoPointer.stagedTraversal;

import java.util.Arrays;

/**
 * Given a string of lowercase English letters, rearrange the characters to form a new string
 * representing the next immediate sequence in lexicographical (alphabetical) order. If the given
 * string is already last in lexicographical order among all possible arrangements, return the
 * arrangement that’s first in lexicographical order.
 */
public class NextLexicographicalSequence {

	/**
	 * Time complexity: O(n)
	 */
	public static String nextLexicographicalSequence(String str) {
		char[] letters = str.toCharArray();

		// Locate the pivot, which is the first character from the right that breaks
		// non - increasing order.Start searching from the second - to - last position,
		// since the last character is neither increasing nor decreasing.
		int pivot = letters.length - 2;

		while (pivot >= 0 && letters[pivot] >= letters[pivot + 1]) {
			pivot--;
		}
		// If pivot is not found, the string is already in its largest permutation. In
		// this case, reverse the string to obtain the smallest permutation.
		if (pivot == -1) {
			return reverseCharArray(letters);
		}

		//Find the rightmost successor to the pivot.
		int rightMostSuccessor = letters.length - 1;
		while (letters[rightMostSuccessor] <= letters[pivot]) {
			rightMostSuccessor--;
		}
		// Swap the rightmost successor with the pivot to increase the lexicographical
		// order of the suffix.
		swap(letters, pivot, rightMostSuccessor);

		// Reverse the suffix after the pivot to minimize its permutation.
		reverseToMinimizePermutation(pivot, letters);

		return String.valueOf(letters);
	}

	private static String reverseCharArray(char[] letters) {
		return new StringBuilder(String.valueOf(letters)).reverse().toString();
	}

	private static void swap(char[] letters, int pivot, int rightMostSuccessor) {
		char temp = letters[pivot];
		letters[pivot] = letters[rightMostSuccessor];
		letters[rightMostSuccessor] = temp;
	}

	private static void reverseToMinimizePermutation(int pivot, char[] letters) {
		StringBuilder temp = new StringBuilder();
		int idx = pivot + 1;
		while (idx != letters.length) {
			temp.append(letters[idx]);
			idx++;
		}

		char[] reversedTemp = reverseCharArray(temp.toString().toCharArray()).toCharArray();
		idx = pivot + 1;
		for (char c : reversedTemp) {
			letters[idx] = c;
			idx++;
		}
	}
}
