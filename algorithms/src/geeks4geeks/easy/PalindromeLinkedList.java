package geeks4geeks.easy;

/**
 * https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1/
 * 
 * @author baibhav <baibhavr@gmail.com> 11:02:58 PM Apr 16, 2022
 */
public class PalindromeLinkedList {
	// Function to check whether the list is palindrome.
	boolean isPalindrome(Node head) {
		if (head.next == null)
			return true;
		if (head.next.next == null)
			return head.data == head.next.data;

		Node runner = head, jogger = head;

		// find mid item
		int mid = 0;
		Node prev = null;
		while (runner != null && runner.next != null) {
			runner = runner.next.next;
			Node temp = jogger.next;
			jogger.next = prev;
			prev = jogger;
			jogger = temp;
			mid++;
		}

		Node left = prev, right = jogger;
		if (mid % 2 == 1) 
			right = right.next;
		while (left != null && right != null && left.data == right.data) {
			left = left.next;
			right = right.next;
		}
		return left == null && right == null;
	}
}

/**
 * Structure of class Node is
 */
class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}
