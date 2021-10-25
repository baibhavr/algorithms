package hackerrank.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SwapNodes {

	/*
	 * Complete the 'swapNodes' function below.
	 * https://www.hackerrank.com/challenges/swap-nodes-algo
	 * The function is expected to return a 2D_INTEGER_ARRAY. The function accepts
	 * following parameters: 1. 2D_INTEGER_ARRAY indexes 2. INTEGER_ARRAY queries
	 */
	public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {

		Node[] NodeArr = new Node[indexes.size() + 2];
		buildTree(indexes, NodeArr);

		List<List<Integer>> answer = new ArrayList<>();

		for (int k : queries) {
			List<Integer> sub_answer = new ArrayList<>();

			Queue<Node> q = new LinkedList<>();
			q.add(NodeArr[1]);
			q.add(new Node(-1));
			int level = 1;
			while (q.size() != 1) {

				Node cur = q.remove();
				if (cur.val == -1) {
					level++;
					q.add(cur);
					continue;
				}

				// SWAP
				if (level % k == 0) {
					Node temp = cur.left;
					cur.left = cur.right;
					cur.right = temp;
				}

				if (cur.left != null)
					q.add(cur.left);
				if (cur.right != null)
					q.add(cur.right);
			}

			inOrder(NodeArr[1], sub_answer);
			answer.add(sub_answer);
		}
		return answer;
	}

	public static void buildTree(List<List<Integer>> indexes, Node[] NodeArr) {
		// Build the Tree

		NodeArr[1] = new Node(1);
		for (int i = 0; i < indexes.size(); i++) {
			int id = i + 1;
			List<Integer> child = indexes.get(i);
			if (child.get(0) != -1) {
				NodeArr[child.get(0)] = new Node(child.get(0));
				NodeArr[id].left = NodeArr[child.get(0)];
			}
			if (child.get(1) != -1) {
				NodeArr[child.get(1)] = new Node(child.get(1));
				NodeArr[id].right = NodeArr[child.get(1)];
			}
		}
	}

	public static void inOrder(Node cur, List<Integer> sub_answer) {
		if (cur == null)
			return;

		inOrder(cur.left, sub_answer);
		sub_answer.add(cur.val);
		inOrder(cur.right, sub_answer);
	}
}

class Node {
	int val;
	Node left, right;

	Node(int val) {
		this.val = val;
	}
}
