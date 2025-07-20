package com.bytebytego.patterns.twoPointer.inwardTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Given an array of integers, return all triplets [a,b,c] such that a + b + c = 0. The solution must not contain
 * duplicate triplets (e.g., [1, 2, 3] and [2, 3, 1] are considered duplicate triplets). If no such triplets are found,
 * return an empty array.
 */
public class TripletSum {

	public static void main(String[] args) {
		System.out.println(tripletSum(new ArrayList<>(List.of(0, -1, 2, -3, 1))));
	}

	public static List<List<Integer>> tripletSumBruteForce(List<Integer> nums) {
		int length = nums.size();
		Set<List<Integer>> triplets = new HashSet<>();

		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				for (int k = j + 1; k < length; k++) {
					if (nums.get(i) + nums.get(j) + nums.get(k) == 0) {
						triplets.add(Stream.of(nums.get(i), nums.get(j), nums.get(k)).sorted().toList());
					}
				}
			}
		}
		if (triplets.isEmpty()) {
			return List.of();
		}

		return new ArrayList<>(triplets);
	}

	public static List<List<Integer>> tripletSum(List<Integer> nums) {
		List<List<Integer>> triplets = new ArrayList<>();
		List<Integer> sortedNums = nums.stream().sorted().toList();
		for (int i = 0; i < sortedNums.size(); i++) {
			if (sortedNums.get(i) > 0) {
				break;
			}

			if (i > 0 && sortedNums.get(i).equals(sortedNums.get(i - 1))) {
				continue;
			}
			List<List<Integer>> pairs = pairSumSortedAllPairs(sortedNums, i + 1, -sortedNums.get(i));
			for(List<Integer> pair : pairs) {
				triplets.add(List.of(sortedNums.get(i), pair.get(0), pair.get(1)));
			}
		}
		return triplets;
	}

	private static List<List<Integer>> pairSumSortedAllPairs(List<Integer> nums, int start, int target) {
		List<List<Integer>> pairs = new ArrayList<>();
		int left = start, right = nums.size() - 1;
		while (left < right) {
			int sum = nums.get(left) + nums.get(right);
			if (sum == target) {
				pairs.add(List.of(nums.get(left), nums.get(right)));
				do {
					left += 1;
				} while (left < right && nums.get(left).equals(nums.get(left - 1)));
			} else if (sum < target) {
				left += 1;
			} else {
				right -= 1;
			}
		}

		return pairs;
	}

}
