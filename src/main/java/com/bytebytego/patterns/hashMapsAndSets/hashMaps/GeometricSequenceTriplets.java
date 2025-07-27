package com.bytebytego.patterns.hashMapsAndSets.hashMaps;

import java.util.HashMap;

/**
 * A geometric sequence triplet is a sequence of three numbers where each successive number is
 * obtained by multiplying the preceding number by a constant called the common ratio.
 */
public class GeometricSequenceTriplets {

	/**
	 * Time complexity: O(n)
	 */
	public static int geometricSequenceTriplets(int[] nums, int commonRatio) {

		HashMap<Integer, Integer> leftMap = new HashMap<>();
		HashMap<Integer, Integer> rightMap = new HashMap<>();
		int count = 0;

		for(int num : nums) {
			rightMap.put(num, rightMap.getOrDefault(num, 0) + 1);
		}

		for(int num : nums) {
			rightMap.put(num, rightMap.get(num) - 1);
			if(num != 0 && num % commonRatio == 0) {
				count += leftMap.getOrDefault(num / commonRatio, 0) *
						rightMap.getOrDefault(num * commonRatio, 0);
			}

			leftMap.put(num, leftMap.getOrDefault(num, 0) + 1);
		}
		return count;
	}

}
