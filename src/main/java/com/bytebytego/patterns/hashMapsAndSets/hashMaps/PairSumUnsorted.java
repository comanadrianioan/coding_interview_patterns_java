package com.bytebytego.patterns.hashMapsAndSets.hashMaps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an array of integers, return the indexes of any two numbers that add up to a target.
 * The order of the indexes in the result doesn't matter. If no pair is found, return an empty array.
 */
public class PairSumUnsorted {

	public static List<Integer> pairSumUnsortedTwoPass(List<Integer> nums, int target) {
		Map<Integer, Integer> numMap = IntStream.range(0, nums.size())
				.boxed()
				.collect(Collectors.toMap(
						nums::get,
						Function.identity()
				));

		for (Map.Entry<Integer, Integer> num : numMap.entrySet()) {
			int complement = target - num.getKey();
			if (numMap.containsKey(complement) &&
					!num.getValue().equals(numMap.get(complement))) {
				return List.of(num.getValue(), numMap.get(complement));
			}
		}

		return List.of();
	}

	public static List<Integer> pairSumUnsorted(List<Integer> nums, int target) {
		HashMap<Integer, Integer> numMap = new HashMap<>();
		for(int i = 0; i < nums.size(); i++) {
			int complement = target - nums.get(i);
			if(numMap.containsKey(complement)) {
				return List.of(numMap.get(complement), i);
			}
				numMap.put(nums.get(i), i);
		}
		return List.of();
	}
}
