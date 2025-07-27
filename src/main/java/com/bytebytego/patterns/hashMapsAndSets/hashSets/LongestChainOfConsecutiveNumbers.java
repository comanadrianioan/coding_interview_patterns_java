package com.bytebytego.patterns.hashMapsAndSets.hashSets;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Find the longest chain of consecutive numbers in an array. Two numbers are consecutive if
 * they have a difference of 1.
 */
public class LongestChainOfConsecutiveNumbers {

	/**
	 * Time complexity: O(n^3)
	 */
	public static int longestChainOfConsecutiveNumbersBruteForce(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int longestChain = 0;
		for (int num : nums) {
			int currentNum = num;
			int currentChain = 1;
			while (contains(nums, currentNum + 1)) {
				currentNum += 1;
				currentChain += 1;
			}

			longestChain = Math.max(longestChain, currentChain);
		}
		return longestChain;
	}

	/**
	 * Time complexity: O(n)
	 */
	public static int longestChainOfConsecutiveNumbers(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		int longestChain = 0;
		for (Integer num : numSet) {
			if(!numSet.contains(num - 1)) {
				int currentNum = num;
				int currentChain = 1;
				while(numSet.contains(currentNum + 1)) {
					currentNum++;
					currentChain++;
				}
				longestChain = Math.max(longestChain, currentChain);
			}
		}
		return longestChain;
	}

	// Helper method to simulate "contains" for int[]
	private static boolean contains(int[] arr, int target) {
		for (int num : arr) {
			if (num == target) {
				return true;
			}
		}
		return false;
	}
}
