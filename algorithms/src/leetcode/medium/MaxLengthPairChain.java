package leetcode.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MaxLengthPairChain {
	
	Map<Integer, Integer> dp = new HashMap<>();

	public int findLongestChain(int[][] pairs) {

		TreeMap<Integer, Integer> edges = new TreeMap<>();

		for (int[] pair : pairs)
			edges.put(pair[0], Math.min(pair[1], edges.getOrDefault(pair[0], Integer.MAX_VALUE)));

		int answer = 0;

		for (Map.Entry<Integer, Integer> edge : edges.entrySet())
			answer = Math.max(answer, dfs(edges, edge.getValue()));

		return 1 + answer;
	}

	int dfs(TreeMap<Integer, Integer> edges, int source) {

		if (dp.containsKey(source))
			return dp.get(source);

		if (edges.tailMap(source, false).size() == 0)
			return 0;

		int min = Collections.min(edges.tailMap(source, false).values());
		int answer = 1 + dfs(edges, min);
		dp.put(source, answer);
		return answer;
	}
}
