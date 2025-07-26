package com.bytebytego.patterns.twoPointer.inwardTraversal;

/**
 * Given a string, determine if it's a palindrome after removing all non-alphanumeric characters. A character is
 * alphanumeric if it's either a letter of a number.
 */
public class IsPalindromeValid {

	/**
	 * Time complexity: O(n)
	 */
	public static boolean isPalindrome(String str) {
		int left = 0, right = str.length() - 1;
		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
				left++;
			}
			while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
				right--;
			}
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
