package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/submissions/
 * @author baibhav <baibhavr@gmail.com>
 * 11:42:07 AM Oct 6, 2021
 */
public class TopKFrequent {

	public int[] topKFrequent(int[] nums, int k) {

		Map<Integer, Integer> count = new HashMap<>();
		for (int num : nums)
			count.put(num, count.getOrDefault(num, 0) + 1);

		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
		for (Map.Entry<Integer, Integer> cur : count.entrySet()) {
			pq.add(cur);
			if (pq.size() > k)
				pq.remove();
		}

		int[] answer = new int[k];
		while (pq.size() != 0)
			answer[pq.size() - 1] = pq.remove().getKey();
		return answer;
	}
}
