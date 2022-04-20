package leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * 
 * @author baibhav <baibhavr@gmail.com> 2:19:42 AM Apr 20, 2022
 */
public class VerticalTraversalBinaryTree {
	public List<List<Integer>> verticalTraversal(TreeNode root) {

		Map<Integer, Map<Integer, List<Integer>>> grid = new HashMap<>();

		dfs(root, 0, 0, grid);

		List<List<Integer>> res = new ArrayList<>();
		int minX = Collections.min(grid.keySet());
		int maxX = Collections.max(grid.keySet());
		for (int i = minX; i <= maxX; i++) {

			List<Integer> cur_column = new ArrayList<>();
			int minY = Collections.min(grid.get(i).keySet());
			int maxY = Collections.max(grid.get(i).keySet());
			for (int j = minY; j <= maxY; j++) {
				if (grid.containsKey(i) && grid.get(i).containsKey(j)) {
					Collections.sort(grid.get(i).get(j));
					cur_column.addAll(grid.get(i).get(j));
				}
			}

			res.add(cur_column);
		}
		return res;
	}

	void dfs(TreeNode cur, int x, int y, Map<Integer, Map<Integer, List<Integer>>> grid) {

		if (cur == null)
			return;

		if (!grid.containsKey(x))
			grid.put(x, new HashMap<>());

		if (!grid.get(x).containsKey(y))
			grid.get(x).put(y, new ArrayList<>());

		grid.get(x).get(y).add(cur.val);

		dfs(cur.left, x - 1, y + 1, grid);
		dfs(cur.right, x + 1, y + 1, grid);
	}
}

/**
 * Definition for a binary tree node.
 * 
 * @author baibhav <baibhavr@gmail.com> 2:21:12 AM Apr 20, 2022
 */
class TreeNode {
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
