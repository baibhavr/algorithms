package hackerrank.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NearestClone {
	/*
	 * For the unweighted graph, <name>:
	 *
	 * 1. The number of nodes is <name>Nodes. 2. The number of edges is <name>Edges.
	 * 3. An edge exists between <name>From[i] to <name>To[i].
	 *
	 */
	static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, int[] ids, int val) {

		ArrayList<Integer>[] graph = new ArrayList[graphNodes + 1];
		for (int i = 1; i <= graphNodes; i++)
			graph[i] = new ArrayList<Integer>();

		for (int i = 0; i < graphFrom.length; i++) {
			graph[graphFrom[i]].add(graphTo[i]);
			graph[graphTo[i]].add(graphFrom[i]);
		}

		int shortestPath = Integer.MAX_VALUE;
		for (int id = 1; id <= ids.length; id++) {

			int color = ids[id - 1];
			if (color != val)
				continue;

			// BFS
			Queue<Integer> q = new LinkedList<>();
			q.add(id);
			q.add(-1);
			Set<Integer> visited = new HashSet<>();
			int level = 0;
			while (q.size() != 1) {

				int cur = q.remove();

				// End of level divider reached
				if (cur == -1) {
					q.add(-1);
					level++;
					continue;
				}
				if (visited.contains(cur))
					continue;
				visited.add(cur);

				// Nearest same color found
				if (cur != id && color == ids[cur - 1]) {
					shortestPath = Math.min(shortestPath, level);
					break;
				}

				// Add neighbors
				for (Integer nb : graph[cur])
					if (!visited.contains(nb))
						q.add(nb);
			}
		}
		return shortestPath == Integer.MAX_VALUE ? -1 : shortestPath;
	}

}
