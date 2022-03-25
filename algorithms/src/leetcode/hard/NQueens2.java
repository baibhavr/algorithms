package leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class NQueens2 {
	
	public int totalNQueens(int n) {

		int[] ans = new int[1];

		Set<Integer> cols = new HashSet<>();
		Set<Integer> left2RightDiag = new HashSet<>();
		Set<Integer> right2LeftDiag = new HashSet<>();

		helper(n, ans, cols, left2RightDiag, right2LeftDiag);
		return ans[0];
	}

	void helper(int n, int[] ans, Set<Integer> cols, Set<Integer> left2RightDiag, Set<Integer> right2LeftDiag) {

		if (cols.size() == n) {
			ans[0]++;
			return;
		}

		for (int col = 0; col < n; col++) {

			int row = cols.size();

			if (cols.contains(col) || left2RightDiag.contains(col - row) || right2LeftDiag.contains(col + row))
				continue;

			cols.add(col);
			left2RightDiag.add(col - row);
			right2LeftDiag.add(col + row);

			helper(n, ans, cols, left2RightDiag, right2LeftDiag);

			cols.remove(col);
			left2RightDiag.remove(col - row);
			right2LeftDiag.remove(col + row);
		}
	}
}
