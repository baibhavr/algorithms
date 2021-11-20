package pramp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.pramp.com/challenge/XdMZJgZoAnFXqwjJwnpZ
 * @author baibhav <baibhavr@gmail.com>
 * 12:54:08 PM Nov 11, 2021
 */
public class KDifferencePair {

	public int[][] findPairs(int[] nums, int k) {
		List<int[]> temp = new ArrayList<>();
		Set<Integer> set = new HashSet<>();

		for (int num : nums) {
			set.add(num - k);
		}

		for (int num : nums) {
			if (set.contains(num)) {
				temp.add(new int[] { k + num, num });
			}
		}

		int[][] answer = new int[temp.size()][2];
		for (int i = 0; i < temp.size(); i++) {
			answer[i] = temp.get(i);
		}
		return answer;
	}
}
