package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 * @author baibhav <baibhavr@gmail.com>
 * 9:12:02 PM Nov 19, 2021
 */
public class Permutations {
	
	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> ans = new ArrayList<>();
		backtrack(ans, new LinkedHashSet<>(), nums);
		return ans;
	}

	void backtrack(List<List<Integer>> ans, LinkedHashSet<Integer> cur, int[] nums) {

		if (cur.size() == nums.length) {
			ans.add(new ArrayList<Integer>(cur));
			return;
		}

		for (int i = 0; i < nums.length; i++) {

			int num = nums[i];

			if (cur.contains(num))
				continue;
			cur.add(num);
			backtrack(ans, cur, nums);
			cur.remove(num);
		}
	}
}
