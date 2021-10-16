package leetcode.easy;

/**
 * https://leetcode.com/problems/subtree-of-another-tree
 * @author baibhav <baibhavr@gmail.com>
 * 1:17:39 AM Oct 13, 2021
 */
public class IsSubtree {
	
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {

		if (isIdentical(root, subRoot))
			return true;

		if (root == null)
			return false;

		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	public boolean isIdentical(TreeNode root1, TreeNode root2) {

		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		if (root1.val != root2.val)
			return false;

		return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
	}

	/**
	 * Definition for a binary tree node.
	 */

	public class TreeNode {
		int val;
		TreeNode left, right;

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
