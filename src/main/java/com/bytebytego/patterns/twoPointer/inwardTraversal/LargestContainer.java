package com.bytebytego.patterns.twoPointer.inwardTraversal;

import java.util.List;

/**
 * You are given an array of numbers, each representing the height of a vertical line on a graph.
 * A container can be formed with any pair of these lines, along with the x-axis of the graph.
 * Return the amount of water which the lardest container can hold.
 */
public class LargestContainer {

	public static int largestContainerBruteForce(List<Integer> heights) {
		int maxWater = 0;
		for (int i = 0; i < heights.size(); i++) {
			for (int j = i + 1; j < heights.size(); j++) {
				int water = Math.min(heights.get(i), heights.get(j)) * (j - i);
				maxWater = Math.max(maxWater, water);
			}
		}
		return maxWater;
	}

	/**
	 * Time complexity: O(n)
	 */
	public static int largestContainer(List<Integer> heights) {
		int left = 0, right = heights.size() - 1;
		int maxWater = 0;
		while (left < right) {
			int water = Math.min(heights.get(left), heights.get(right)) * (right - left);
			maxWater = Math.max(maxWater, water);

			if (heights.get(left) < heights.get(right)) {
				left++;
			} else if (heights.get(left) > heights.get(right)) {
				right--;
			} else {
				left++;
				right--;
			}
		}

		return maxWater;
	}

}
