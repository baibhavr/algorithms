package leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> ans = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();

		TreeNode cur = root;
		while (cur != null || st.size() != 0) {

			while (cur != null) {
				st.push(cur);
				cur = cur.left;
			}
			TreeNode popped = st.pop();
			ans.add(popped.val);
			cur = popped.right;
		}
		return ans;
	}

	public List<Integer> inorderTraversalRecursive(TreeNode root) {

		List<Integer> answer = new ArrayList<>();
		if (root == null)
			return answer;

		answer.addAll(inorderTraversalRecursive(root.left));
		answer.add(root.val);
		answer.addAll(inorderTraversalRecursive(root.right));

		return answer;
	}

	/**
	 * Definition for a binary tree node.
	 */
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
