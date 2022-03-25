package leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

	public List<List<String>> solveNQueens(int n) {

		List<List<String>> ans = new ArrayList<>();
		helper(n, ans, new ArrayList<>(),new HashSet<>(),new HashSet<>(),new HashSet<>());
		return ans;
	}

	void helper(int n, List<List<String>> ans, List<String> res, Set<Integer> cols, Set<Integer> left2rightDiag, Set<Integer> right2leftDiag) {

		if (res.size() == n)
			ans.add(new ArrayList<>(res));

		for (int col = 0; col < n; col++) {

			if (cols.contains(col) || left2rightDiag.contains(col - res.size()) || right2leftDiag.contains(col + res.size()))
				continue;

			cols.add(col);
			left2rightDiag.add(col - res.size());
			right2leftDiag.add(col + res.size());

			StringBuilder sb = new StringBuilder();
			sb.append(".".repeat(col));
			sb.append("Q");
			sb.append(".".repeat(n - 1 - col));
			res.add(sb.toString());

			helper(n, ans, res, cols, left2rightDiag, right2leftDiag);

			res.remove(res.size() - 1);
			cols.remove(col);
			left2rightDiag.remove(col - res.size());
			right2leftDiag.remove(col + res.size());
		}
	}
}
