package com.bytebytego.patterns.twoPointer.inwardTraversal;

import java.util.List;

public class PairSumSorted {

	public static void main(String[] args) {
		System.out.println(pairSumSortedBruteForce(List.of(-5, -2, 3, 4, 6), 7));
	}

	/*
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

	/*
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