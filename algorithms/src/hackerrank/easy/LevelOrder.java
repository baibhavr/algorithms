package hackerrank.easy;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

	public static void levelOrder(Node root) {

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (q.size() != 0) {

			Node cur = q.remove();
			System.out.print(cur.data + " ");

			if (cur.left != null)
				q.add(cur.left);
			if (cur.right != null)
				q.add(cur.right);
		}
	}

	class Node {
		int data;
		Node left;
		Node right;
	}
}
