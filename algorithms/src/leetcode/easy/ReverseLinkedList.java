package leetcode.easy;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * @author baibhav <baibhavr@gmail.com>
 * 11:44:02 PM Nov 20, 2021
 */
public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {

		ListNode cur = head, prev = null;
		while (cur != null) {
			ListNode realNext = cur.next;
			cur.next = prev;
			prev = cur;
			cur = realNext;
		}
		return prev;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
