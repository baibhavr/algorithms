package geeks4geeks.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://practice.geeksforgeeks.org/problems/minimum-cost-path3833/1
 * @author baibhav <baibhavr@gmail.com>
 * 4:52:27 AM Apr 22, 2022
 */
public class MinimumCostPath {

	/**
	 * Function to return the minimum cost to react at bottom
	 * right cell from top left cell.
	 * Uses Dijkstra's algorithm
	 * @param grid
	 * @return
	 */
	public int minimumCostPath(int[][] grid) {

		int m = grid.length - 1, n = grid[0].length - 1;
		int[][] cost = new int[m + 1][n + 1];

		for (int[] c : cost)
			Arrays.fill(c, Integer.MAX_VALUE);
		cost[0][0] = grid[0][0];

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(cost[a[0]][a[1]], cost[b[0]][b[1]]));

		pq.add(new int[] { 0, 0 });

		while (pq.size() != 0) {

			int[] cur = pq.remove();

			int[][] neighbors = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

			for (int[] step : neighbors) {

				int[] nb = new int[] { cur[0] + step[0], cur[1] + step[1] };
				if (nb[0] < 0 || nb[0] > m || nb[1] < 0 || nb[1] > n)
					continue;

				int newCost = cost[cur[0]][cur[1]] + grid[nb[0]][nb[1]];
				if (newCost < cost[nb[0]][nb[1]]) {
					cost[nb[0]][nb[1]] = newCost;
					pq.add(nb);
				}
			}
		}

		return cost[m][n];
	}
}
