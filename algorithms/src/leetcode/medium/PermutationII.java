package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {
	public List<List<Integer>> permuteUnique(int[] nums) {

		Arrays.sort(nums);
		boolean[] flag = new boolean[nums.length];
		List<List<Integer>> ans = new ArrayList<>();
		backtracking(ans, new ArrayList<>(), nums, flag);
		return ans;
	}

	void backtracking(List<List<Integer>> ans, List<Integer> cur, int[] nums, boolean[] flag) {

		if (cur.size() == nums.length) {
			ans.add(new ArrayList<>(cur));
			return;
		}

		for (int i = 0; i < nums.length; i++) {

			if (i != 0 && nums[i] == nums[i - 1] && !flag[i - 1])
				continue;
			if (flag[i])
				continue;

			flag[i] = true;
			cur.add(nums[i]);
			backtracking(ans, cur, nums, flag);
			cur.remove(cur.size() - 1);
			flag[i] = false;
		}
	}
}
