package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> answer = new ArrayList<>();
		rightView(answer, root, 0);
		return answer;
	}

	public void rightView(List<Integer> answer, TreeNode cur, int level) {

		if (cur == null)
			return;

		if (answer.size() == level)
			answer.add(cur.val);

		rightView(answer, cur.right, level + 1);
		rightView(answer, cur.left, level + 1);
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
