package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * @author baibhav <baibhavr@gmail.com>
 * 4:48:39 PM Oct 19, 2021
 */
public class PartitionEqualSubsetSum {
	Map<String, Boolean> map = new HashMap<>();

	public boolean canPartition(int[] nums) {

		int sum = 0;
		for (int num : nums)
			sum += num;
		if (sum % 2 == 1)
			return false;

		return canPartition(nums, 0, 0, sum);
	}

	boolean canPartition(int[] nums, int i, int sum, int target) {

		String current = "" + sum;
		if (map.containsKey(current))
			return map.get(current);

		if (sum * 2 == target)
			return true;

		if (sum > target / 2 || i >= nums.length)
			return false;

		boolean answer = canPartition(nums, i + 1, sum, target) || canPartition(nums, i + 1, sum + nums[i], target);
		map.put(current, answer);
		return answer;
	}
}
