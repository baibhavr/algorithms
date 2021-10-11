package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * @author baibhav <baibhavr@gmail.com>
 * 12:58:02 AM Oct 10, 2021
 */
public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		List<int[]> answer = new ArrayList<>();
		answer.add(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {

			int[] last = answer.get(answer.size() - 1);
			if (last[1] >= intervals[i][0])
				last[1] = Math.max(last[1], intervals[i][1]);
			else
				answer.add(intervals[i]);
		}

		return answer.toArray(new int[0][]);
	}
}
