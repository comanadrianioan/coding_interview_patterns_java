package com.bytebytego.patterns.twoPointer.inwardTraversal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IsPalindromeValidTest {

	@DisplayName("Is Palindrome Valid")
	@ParameterizedTest(name = "Input string \"{0}\" should return {1}")
	@MethodSource("isPalindromeTestCases")
	void isPalindrome(String input, boolean expectedResult) {
		assertEquals(expectedResult, IsPalindromeValid.isPalindrome(input));
	}

	private static Stream<Arguments> isPalindromeTestCases() {
		return Stream.of(
				Arguments.of("", true),
				Arguments.of("a", true),
				Arguments.of("aa", true),
				Arguments.of("ab", false),
				Arguments.of("!, (?)", true),
				Arguments.of("12.02.2021", true),
				Arguments.of("21.02.2021", false),
				Arguments.of("hello, world!", false),
				Arguments.of("a dog! a panic in a pagoda.", true)
		);
	}
}