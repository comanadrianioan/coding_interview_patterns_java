# ByteByteGo Coding Interview Patterns in Java

This repository contains Java implementations of coding interview problems based on the **ByteByteGo Coding Interview Patterns**.  

About the book: https://blog.bytebytego.com/p/my-new-book-coding-interview-patterns

## Goal
The goal of this project is to systematically solve and document solutions to problems from ByteByteGo's curated set of coding interview patterns, using clean, efficient, and well-structured Java code.

### <ins>Two Pointer Pattern</ins>

#### 🎯 Inward Traversal
| Problem | Description | Solution | Test |
|---------|-------------|----------|------|
| **Valid Palindrome** | Given a string, determine if it's a palindrome after removing all non-alphanumeric characters | [Solution](src/main/java/com/bytebytego/patterns/twoPointer/inwardTraversal/IsPalindromeValid.java) | [Test](src/test/java/com/bytebytego/patterns/twoPointer/inwardTraversal/IsPalindromeValidTest.java) |
| **Container With Most Water** | Given an array of heights, find the largest container that can hold the most water | [Solution](src/main/java/com/bytebytego/patterns/twoPointer/inwardTraversal/LargestContainer.java) | [Test](src/test/java/com/bytebytego/patterns/twoPointer/inwardTraversal/LargestContainerTest.java) |
| **Two Sum - Sorted Array** | Given a sorted array and a target value, return indexes of any pair that sums to the target | [Solution](src/main/java/com/bytebytego/patterns/twoPointer/inwardTraversal/PairSumSorted.java) | [Test](src/test/java/com/bytebytego/patterns/twoPointer/inwardTraversal/PairSumSortedTest.java) |
| **Three Sum** | Given an array of integers, return all triplets [a,b,c] such that a + b + c = 0 | [Solution](src/main/java/com/bytebytego/patterns/twoPointer/inwardTraversal/TripletSum.java) | [Test](src/test/java/com/bytebytego/patterns/twoPointer/inwardTraversal/TripletSumTest.java) |

#### 🔄 Staged Traversal
| Problem | Description | Solution | Test |
|---------|-------------|----------|------|
| **Next Lexicographical Permutation** | Rearrange characters to form the next immediate sequence in lexicographical order | [Solution](src/main/java/com/bytebytego/patterns/twoPointer/stagedTraversal/NextLexicographicalSequence.java) | [Test](src/test/java/com/bytebytego/patterns/twoPointer/stagedTraversal/NextLexicographicalSequenceTest.java) |

#### ➡️ Unidirectional Traversal
| Problem | Description | Solution | Test |
|---------|-------------|----------|------|
| **Move Zeros** | Move all zeros to the end while maintaining the relative order of non-zero elements | [Solution](src/main/java/com/bytebytego/patterns/twoPointer/unidirectionalTraversal/ShiftZerosToTheEnd.java) | [Test](src/test/java/com/bytebytego/patterns/twoPointer/unidirectionalTraversal/ShiftZerosToTheEndTest.java) |