package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/3sum/
 * @author baibhav <baibhavr@gmail.com>
 * 12:14:09 AM Oct 6, 2021
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {

		Set<List<Integer>> answer = new HashSet<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {

			int j = i + 1, k = nums.length - 1;

			int goal = -nums[i];
			while (j < k) { // todo: pruning opportunity

				int sum = nums[j] + nums[k];
				if (sum < goal) 		j++;
				else if (sum > goal) 	k--;
				else {
					answer.add(new ArrayList<>(Arrays.asList(nums[i], nums[j++], nums[k--])));
					while (j < k && nums[j - 1] == nums[j])	j++;
					while (j > k && nums[k + 1] == nums[k])	k--;
				}
			}
		}
		return new ArrayList<List<Integer>>(answer);
	}
}
