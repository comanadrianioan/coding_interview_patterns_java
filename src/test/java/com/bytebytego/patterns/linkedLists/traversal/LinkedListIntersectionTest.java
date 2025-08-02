package com.bytebytego.patterns.linkedLists.traversal;

import com.bytebytego.patterns.linkedLists.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

class LinkedListIntersectionTest {

	@DisplayName("Linked List Intersection")
	@ParameterizedTest(name = "Test Case #{index}")
	@MethodSource("linkedListIntersectionTestCases")
	void linkedListIntersection(TestCase testCase) {
		ListNode result = LinkedListIntersection.linkedListIntersection(testCase.headA, testCase.headB);
		assertEquals(testCase.expected, result);
	}

	static Stream<TestCase> linkedListIntersectionTestCases() {
		return Stream.of(
			// Test case 1: Lists intersect at middle
			createTestCase1(),
			// Test case 2: Lists intersect at beginning of one list
			createTestCase2(),
			// Test case 3: Lists intersect at end
			createTestCase3(),
			// Test case 4: Lists don't intersect
			createTestCase4(),
			// Test case 5: Lists are identical
			createTestCase5(),
			// Test case 6: One list is subset of another
			createTestCase6(),
			// Test case 7: Lists with single node intersection
			createTestCase7(),
			// Test case 8: Lists with different lengths, intersection at end
			createTestCase8()
		);
	}

	private static TestCase createTestCase1() {
		ListNode node8 = new ListNode(8);
		ListNode node7 = new ListNode(7);
		ListNode node2 = new ListNode(2);
		
		node8.setNext(node7);
		node7.setNext(node2);
		
		// List A: 1 -> 3 -> 4 -> 8 -> 7 -> 2
		ListNode headA = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		headA.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node8);
		
		// List B: 6 -> 4 -> 8 -> 7 -> 2
		ListNode headB = new ListNode(6);
		ListNode node4_2 = new ListNode(4);
		headB.setNext(node4_2);
		node4_2.setNext(node8);
		
		return new TestCase(headA, headB, node8);
	}

	private static TestCase createTestCase2() {
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node3.setNext(node4);
		node4.setNext(node5);
		
		// List A: 1 -> 2 -> 3 -> 4 -> 5
		ListNode headA = new ListNode(1);
		ListNode node2 = new ListNode(2);
		headA.setNext(node2);
		node2.setNext(node3);
		
		// List B: 3 -> 4 -> 5
		ListNode headB = node3;
		
		return new TestCase(headA, headB, node3);
	}

	private static TestCase createTestCase3() {
		ListNode node4 = new ListNode(4);
		
		// List A: 1 -> 2 -> 3 -> 4
		ListNode headA = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		headA.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		
		// List B: 5 -> 6 -> 7 -> 4
		ListNode headB = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		headB.setNext(node6);
		node6.setNext(node7);
		node7.setNext(node4);
		
		return new TestCase(headA, headB, node4);
	}

	private static TestCase createTestCase4() {
		// List A: 1 -> 2 -> 3 -> 4
		ListNode headA = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		headA.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		
		// List B: 5 -> 6 -> 7 -> 8
		ListNode headB = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		headB.setNext(node6);
		node6.setNext(node7);
		node7.setNext(node8);
		
		return new TestCase(headA, headB, null);
	}

	private static TestCase createTestCase5() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		
		ListNode headA = node1;
		ListNode headB = node1;
		
		return new TestCase(headA, headB, node1);
	}

	private static TestCase createTestCase6() {
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node3.setNext(node4);
		node4.setNext(node5);
		
		// List A: 1 -> 2 -> 3 -> 4 -> 5
		ListNode headA = new ListNode(1);
		ListNode node2 = new ListNode(2);
		headA.setNext(node2);
		node2.setNext(node3);
		
		// List B: 3 -> 4 -> 5
		ListNode headB = node3;
		
		return new TestCase(headA, headB, node3);
	}

	private static TestCase createTestCase7() {
		ListNode node3 = new ListNode(3);
		
		// List A: 1 -> 2 -> 3
		ListNode headA = new ListNode(1);
		ListNode node2 = new ListNode(2);
		headA.setNext(node2);
		node2.setNext(node3);
		
		// List B: 4 -> 5 -> 3
		ListNode headB = new ListNode(4);
		ListNode node5 = new ListNode(5);
		headB.setNext(node5);
		node5.setNext(node3);
		
		return new TestCase(headA, headB, node3);
	}

	private static TestCase createTestCase8() {
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		
		node5.setNext(node6);
		
		// List A: 1 -> 2 -> 3 -> 4 -> 5 -> 6
		ListNode headA = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		headA.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		
		// List B: 7 -> 8 -> 9 -> 5 -> 6
		ListNode headB = new ListNode(7);
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);
		headB.setNext(node8);
		node8.setNext(node9);
		node9.setNext(node5);
		
		return new TestCase(headA, headB, node5);
	}

	record TestCase(ListNode headA, ListNode headB, ListNode expected) {
		@Override
		public String toString() {
			return String.format("headA=%s, headB=%s, expected=%s", 
				headA != null ? headA.toString() : "null",
				headB != null ? headB.toString() : "null",
				expected != null ? expected.toString() : "null");
		}
	}
}