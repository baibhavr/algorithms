package pramp;

/**
 * https://www.pramp.com/challenge/pK6A4GA5YES09qKmqG33
 * @author baibhav <baibhavr@gmail.com>
 * 11:54:56 AM Nov 10, 2021
 */
public class LargestSmallestBSTKey {

	Node root;

	int findLargestSmallerKey(int num) {

		int result = -1;

		Node cur = root;
		while (cur != null) {
			if (num > cur.key) {
				result = cur.key;
				cur = cur.right;
			} else {
				cur = cur.left;
			}
		}
		return result;
	}

	class Node {
		int key;
		Node left;
		Node right;
		Node parent;

		Node(int key) {
			this.key = key;
			left = null;
			right = null;
			parent = null;
		}
	}
}
