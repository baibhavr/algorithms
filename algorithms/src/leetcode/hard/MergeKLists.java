package leetcode.hard;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists
 * @author baibhav <baibhavr@gmail.com>
 * 8:08:19 PM Oct 12, 2021
 */
public class MergeKLists {
	public ListNode mergeKLists(ListNode[] lists) {

		PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

		for (int i = 0; i < lists.length; i++)
			if (lists[i] != null)
				pq.add(lists[i]);

		ListNode answer = new ListNode(), iterator = answer;
		while (pq.size() != 0) {

			ListNode cur = pq.remove();
			iterator.next = cur;
			iterator = iterator.next;

			if (cur.next != null)
				pq.add(cur.next);

		}
		return answer.next;
	}

	/**
	 * Definition for singly-linked list.
	 */
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
