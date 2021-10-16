package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {
	public Node copyRandomList(Node head) {
		Map<Node, Node> map = new HashMap<>(); // <Original Node, Copied Node>

		Node cur = head;
		while (cur != null) {
			Node copy = new Node(cur.val);
			copy.next = cur.next;
			copy.random = cur.random;
			map.put(cur, copy);
			cur = cur.next;
		}

		cur = map.get(head);
		while (cur != null) {
			cur.next = map.get(cur.next);
			cur.random = map.get(cur.random);
			cur = cur.next;
		}
		return map.get(head);
	}

	// Definition for a Node.
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
}
