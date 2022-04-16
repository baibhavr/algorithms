package geeks4geeks.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://practice.geeksforgeeks.org/problems/find-the-string-in-grid0111/1/
 * 
 * @author baibhav <baibhavr@gmail.com> 4:41:04 PM Apr 16, 2022
 */
public class StringInGrid {
	public int[][] searchWord(char[][] grid, String word) {
		List<int[]> ans = new ArrayList<>();
		int m = grid.length, n = grid[0].length, w = word.length();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int[] cur = new int[] { i, j };
				if (found(grid, word, cur, m, n, w))
					ans.add(cur);
			}
		}

		int[][] res = new int[ans.size()][2];
		for (int i = 0; i < ans.size(); i++)
			res[i] = ans.get(i);
		return res;
	}

	boolean found(char[][] grid, String word, int[] start, int m, int n, int w) {

		int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

		for (int[] next : direction) {

			int[] end = new int[] { start[0] + next[0] * (w - 1), start[1] + next[1] * (w - 1) };
			if (end[0] < 0 || end[0] >= m || end[1] < 0 || end[1] >= n)
				continue;

			int[] cur = start.clone();
			for (int i = 0; i < w; i++) {

				char ch = word.charAt(i);
				if (grid[cur[0]][cur[1]] != ch)
					break;

				if (i == w - 1)
					return true;
				cur[0] += next[0];
				cur[1] += next[1];
			}
		}
		return false;
	}
}
