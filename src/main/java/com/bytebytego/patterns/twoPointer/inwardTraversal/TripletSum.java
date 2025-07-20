package com.bytebytego.patterns.twoPointer.inwardTraversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Given an array of integers, return all triplets [a,b,c] such that a + b + c = 0. The solution must not contain
 * duplicate triplets (e.g., [1, 2, 3] and [2, 3, 1] are considered duplicate triplets). If no such triplets are found,
 * return an empty array.
 */
public class TripletSum {

	public static void main(String[] args) {
		System.out.println(tripletSumBruteForce(List.of(0, -1, 2, -3, 1)));
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

}
