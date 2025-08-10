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

### <ins>Hash Maps and Sets Pattern</ins>

#### 🗺️ Hash Maps
| Problem | Description | Solution | Test |
|---------|-------------|----------|------|
| **Geometric Sequence Triplets** | Find count of geometric sequence triplets with a given common ratio | [Solution](src/main/java/com/bytebytego/patterns/hashMapsAndSets/hashMaps/GeometricSequenceTriplets.java) | [Test](src/test/java/com/bytebytego/patterns/hashMapsAndSets/hashMaps/GeometricSequenceTripletsTest.java) |
| **Two Sum - Unsorted Array** | Given an unsorted array and a target value, return indexes of any pair that sums to the target | [Solution](src/main/java/com/bytebytego/patterns/hashMapsAndSets/hashMaps/PairSumUnsorted.java) | [Test](src/test/java/com/bytebytego/patterns/hashMapsAndSets/hashMaps/PairSumUnsortedTest.java) |

#### 🔢 Hash Sets
| Problem                          | Description | Solution | Test |
|----------------------------------|-------------|----------|------|
| **Longest Consecutive Sequence** | Find the longest chain of consecutive numbers in an array | [Solution](src/main/java/com/bytebytego/patterns/hashMapsAndSets/hashSets/LongestChainOfConsecutiveNumbers.java) | [Test](src/test/java/com/bytebytego/patterns/hashMapsAndSets/hashSets/LongestChainOfConsecutiveNumbersTest.java) |
| **Valid Sudoku**                 | Determine if a partially completed 9x9 Sudoku board is valid | [Solution](src/main/java/com/bytebytego/patterns/hashMapsAndSets/hashSets/VerifySudokuBoard.java) | [Test](src/test/java/com/bytebytego/patterns/hashMapsAndSets/hashSets/VerifySudokuBoardTest.java) |
| **Zero Stripping**               | For each zero in a matrix, set its entire row and column to zero in place | [Solution](src/main/java/com/bytebytego/patterns/hashMapsAndSets/hashSets/ZeroStriping.java) | [Test](src/test/java/com/bytebytego/patterns/hashMapsAndSets/hashSets/ZeroStripingTest.java) |

### <ins>Linked Lists Pattern</ins>

#### 🔄 Traversal
| Problem | Description | Solution | Test |
|---------|-------------|----------|------|
| **Linked List Intersection** | Find the intersection point of two linked lists | [Solution](src/main/java/com/bytebytego/patterns/linkedLists/traversal/LinkedListIntersection.java) | [Test](src/test/java/com/bytebytego/patterns/linkedLists/traversal/LinkedListIntersectionTest.java) |
| **Palindromic Linked List** | Determine if a linked list is a palindrome | [Solution](src/main/java/com/bytebytego/patterns/linkedLists/traversal/PalindromicLinkedList.java) | [Test](src/test/java/com/bytebytego/patterns/linkedLists/traversal/PalindromicLinkedListTest.java) |

#### 🔀 Restructuring
| Problem | Description | Solution | Test |
|---------|-------------|----------|------|
| **Flatten Multi-Level List** | Flatten a multi-level doubly linked list into a single level list | [Solution](src/main/java/com/bytebytego/patterns/linkedLists/restructuring/FlattenMultiLevelLinkedList.java) | [Test](src/test/java/com/bytebytego/patterns/linkedLists/restructuring/FlattenMultiLevelLinkedListTest.java) |
| **Linked List Reversal** | Reverse a linked list | [Solution](src/main/java/com/bytebytego/patterns/linkedLists/restructuring/LinkedListReversal.java) | [Test](src/test/java/com/bytebytego/patterns/linkedLists/restructuring/LinkedListReversalTest.java) |
| **Remove Kth Last Node** | Remove the kth node from the end of a linked list | [Solution](src/main/java/com/bytebytego/patterns/linkedLists/restructuring/RemoveKthLastNode.java) | [Test](src/test/java/com/bytebytego/patterns/linkedLists/restructuring/RemoveKthLastNodeTest.java) |

#### 🔄 Doubly Linked List
| Problem | Description | Solution | Test |
|---------|-------------|----------|------|
| **LRU Cache** | Implement a Least Recently Used (LRU) cache | [Solution](src/main/java/com/bytebytego/patterns/linkedLists/doublyLinkedList/LRUCache.java) | [Test](src/test/java/com/bytebytego/patterns/linkedLists/doublyLinkedList/LRUCacheTest.java) |