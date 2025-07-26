package com.bytebytego.patterns.twoPointer.stagedTraversal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NextLexicographicalSequenceTest {

	@DisplayName("Next Lexicographical Sequence")
	@ParameterizedTest(name = "Input {0}, expected output {1}")
	@MethodSource("nextLexicographicalSequenceTestCases")
	void nextLexicographicalSequence(String input, String output) {
		assertEquals(output, NextLexicographicalSequence.nextLexicographicalSequence(input));
	}

	private static Stream<Arguments> nextLexicographicalSequenceTestCases() {
		return Stream.of(
				Arguments.of("a", "a"),
				Arguments.of("aaaa", "aaaa"),
				Arguments.of("ynitsed", "ynsdeit"),
				Arguments.of("abcd", "abdc"),
				Arguments.of("dcba", "abcd")
		);
	}
}
