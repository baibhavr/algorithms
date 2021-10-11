package hackerrank.hard;

import java.io.*;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach
 * @author baibhav <baibhavr@gmail.com>
 * 2:51:43 AM Oct 10, 2021
 */
public class ShortestReach {

	static void shortestReach(int n, int m, int start, List<int[]> edges) {

		// Build graph
		List<Integer>[] graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			graph[i] = new ArrayList<>();
		for (int[] edge : edges) {
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
		}

		int[] distances = new int[n + 1];
		bfs(graph, start, distances);

		for (int i = 1; i <= n; i++) {
			if (i == start)
				continue;
			int ans = distances[i] == 0 ? -1 : 6 * distances[i];
			System.out.print(ans + " ");
		}
		System.out.println();
	}

	static void bfs(List<Integer>[] graph, int start, int[] distances) {
		Queue<Integer> q = new LinkedList<>();
		int distance = 0;
		q.add(start);
		q.add(-1);

		while (q.size() != 1) {

			int cur = q.remove();
			if (cur == -1) {
				distance++;
				q.add(-1);
				continue;
			}

			if (cur != start && distances[cur] != 0)
				continue;
			distances[cur] = distance;
			// Check neighbors
			for (int nb : graph[cur])
				if (distances[nb] == 0 && nb != start)
					q.add(nb);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedInputStream(System.in));

		int cases = sc.nextInt();
		for (int i = 0; i < cases; i++) {
			int n = sc.nextInt(), m = sc.nextInt();

			List<int[]> edges = new ArrayList<>();
			for (int j = 0; j < m; j++)
				edges.add(new int[] { sc.nextInt(), sc.nextInt() });
			int start = sc.nextInt();
			shortestReach(n, m, start, edges);
		}
	}
}
