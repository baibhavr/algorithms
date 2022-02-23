package leetcode.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst
 * @author baibhav <baibhavr@gmail.com>
 * 8:11:22 PM Nov 26, 2021
 */
public class KthSmallestElementBST {
	public int kthSmallest(TreeNode root, int k) {

		Stack<TreeNode> st = new Stack<>();
		TreeNode cur = root;
		int i = 0;

		while (cur != null || st.size() != 0) {

			while (cur != null) {
				st.push(cur);
				cur = cur.left;
			}

			TreeNode popped = st.pop();
			if (++i == k)
				return popped.val;
			cur = popped.right;
		}
		return -1;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
