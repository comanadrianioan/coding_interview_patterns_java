package com.bytebytego.patterns.twoPointer.inwardTraversal;

import java.util.List;

/**
 * Given an array of integers sorted in ascending order and a target value, return the indexes of any pair of numbers
 * in the array that sums to the target. The order of the indexes in the result doesn't matter. If no pair is found,
 * return an empty array.
 */
public class PairSumSorted {

	/**
	 * Time complexity: O(n^2)
	 */
	public static List<Integer> pairSumSortedBruteForce(List<Integer> nums, int target) {
		int length = nums.size();
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (nums.get(i) + nums.get(j) == target) {
					return List.of(i, j);
				}
			}
		}
		return List.of();
	}

	/**
	 * Time complexity: O(n)
	 */
	public static List<Integer> pairSumSorted(List<Integer> nums, int target) {
		int left = 0, right = nums.size() - 1;
		while (left < right) {
			int sum = nums.get(left) + nums.get(right);
			if (sum < target) {
				left += 1;
			} else if (sum > target) {
				right -= 1;
			} else {
				return List.of(left, right);
			}
		}
		return List.of();
	}
}