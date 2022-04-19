package geeks4geeks.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1#
 * 
 * @author baibhav <baibhavr@gmail.com> 12:18:48 AM Apr 19, 2022
 */
public class NumberOfIslands {
	// Function to find the number of islands.
	public int numIslands(char[][] grid) {

		int m = grid.length - 1, n = grid[0].length - 1;
		int ans = 0;

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {

				if (grid[i][j] == '1') {
					ans++;
					bfs(grid, m, n, new int[] { i, j });
				}
			}
		}
		return ans;
	}

	void bfs(char[][] grid, int m, int n, int[] start) {

		Queue<int[]> q = new LinkedList<>();
		q.add(start);

		while (q.size() != 0) {

			int[] cur = q.remove();
			if (grid[cur[0]][cur[1]] == '0')
				continue;
			grid[cur[0]][cur[1]] = '0';

			int row, col;
			for (int i = -1; i < 2; i++) {

				row = cur[0] + i;
				if (row < 0 || row > m)
					continue;

				for (int j = -1; j < 2; j++) {

					if (i == 0 && j == 0)
						continue;
					col = cur[1] + j;

					if (col < 0 || col > n)
						continue;
					if (grid[row][col] == '1')
						q.add(new int[] { row, col });
				}
			}
		}
	}
}
