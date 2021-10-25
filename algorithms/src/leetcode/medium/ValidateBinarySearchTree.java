package leetcode.medium;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return isValid(root, null, null);
	}

	boolean isValid(TreeNode cur, Integer min, Integer max) {

		if (cur == null)
			return true;

		if ((min != null && cur.val <= min) || (max != null && cur.val >= max))
			return false;

		return isValid(cur.left, min, cur.val) && isValid(cur.right, cur.val, max);
	}

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
