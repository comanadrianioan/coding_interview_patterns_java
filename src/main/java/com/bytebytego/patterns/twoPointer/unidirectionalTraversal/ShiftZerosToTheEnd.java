package com.bytebytego.patterns.twoPointer.unidirectionalTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, modify the array in place to move all zeros to the end while maintaining the relative
 * order of non-zero elements,
 */
public class ShiftZerosToTheEnd {

	public static void main(String[] args) {
		System.out.println(shiftZerosToTheEndNaive(new ArrayList<>(List.of(0, 1, 0, 3, 2))));
		System.out.println(Arrays.toString(shiftZerosToTheEndNaive(new int[]{0, 1, 0, 3, 2})));
	}

	public static List<Integer> shiftZerosToTheEndNaive(List<Integer> nums) {
		List<Integer> nonZero = nums.stream().filter(num -> num != 0).toList();
		for(int i = 0; i < nums.size(); i++) {
			if(i < nonZero.size()){
				nums.set(i, nonZero.get(i));
			} else {
				nums.set(i, 0);
			}
		}
		return nums;
	}

	public static int[] shiftZerosToTheEndNaive(int[] nums) {
		int[] temp = new int[nums.length];

		int i = 0;
		for(int num : nums ) {
			if(num != 0) {
				temp[i] = num;
				i++;
			}
		}

		System.arraycopy(temp, 0, nums, 0, nums.length);
		return nums;
	}

	public static int[] shiftZerosToTheEnd(int[] nums) {
		// ToDo :: implement shitZerosToTheEnd
	}
}
