package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {

		// Build graph
		List<Integer>[] graph = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++)
			graph[i] = new ArrayList<Integer>();

		for (int[] edge : prerequisites)
			graph[edge[0]].add(edge[1]);

		Set<Integer> visited = new HashSet<>();
		List<Integer> answer = new ArrayList<Integer>();

		for (int seed = 0; seed < numCourses; seed++) {
			if (!visited.contains(seed)) {

				if (!dfs(graph, visited, new HashSet<Integer>(), answer, seed))
					return new int[] {};
			}
		}

		int[] ans = new int[numCourses];
		for (int i = 0; i < numCourses; i++)
			ans[i] = answer.get(i);
		return ans;
	}

	public boolean dfs(List<Integer>[] graph, Set<Integer> visited, Set<Integer> dfsSet, List<Integer> answer,
			int cur) {

		dfsSet.add(cur);
		visited.add(cur);
		// iterate over neighbors
		for (int nb : graph[cur]) {
			if (dfsSet.contains(nb))
				return false;
			if (visited.contains(nb))
				continue;
			if (!dfs(graph, visited, dfsSet, answer, nb))
				return false;
		}
		answer.add(cur);
		dfsSet.remove(cur);
		return true;
	}
}
