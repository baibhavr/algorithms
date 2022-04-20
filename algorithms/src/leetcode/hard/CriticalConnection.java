package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/critical-connections-in-a-network/
 * 
 * @author baibhav <baibhavr@gmail.com> 2:16:01 AM Apr 20, 2022
 */
public class CriticalConnection {
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

		// READ THE GRAPH
		ArrayList<Integer>[] graph = new ArrayList[n];

		for (int i = 0; i < n; i++)
			graph[i] = new ArrayList<Integer>();
		for (List<Integer> edges : connections) {
			graph[edges.get(0)].add(edges.get(1));
			graph[edges.get(1)].add(edges.get(0));
		}

		// Invoke Tarjan's Algorithm
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		tarjanAlgorithm(graph, -1, 0, new int[1], new int[n], new int[n], res);
		return res;
	}

	public void tarjanAlgorithm(ArrayList<Integer>[] graph, int prev, int cur, int time[], int[] visitedTime,
			int[] lowestReach, List<List<Integer>> res) {
		// Initial values
		visitedTime[cur] = lowestReach[cur] = time[0]++;

		for (int nb : graph[cur]) {

			if (nb != prev) { // if not parent
				if (visitedTime[nb] == 0) {
					tarjanAlgorithm(graph, cur, nb, time, visitedTime, lowestReach, res);
					lowestReach[cur] = Math.min(lowestReach[cur], lowestReach[nb]);
					if (visitedTime[cur] < lowestReach[nb])
						res.add(Arrays.asList(cur, nb));
				} else
					lowestReach[cur] = Math.min(lowestReach[cur], lowestReach[nb]);
			}
		}
	}
}
