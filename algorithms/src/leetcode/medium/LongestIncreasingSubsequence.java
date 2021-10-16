package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * @author baibhav <baibhavr@gmail.com>
 * 3:26:28 AM Oct 12, 2021
 */
public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {

		List<Integer> piles = new ArrayList<>();
		for (int num : nums) {

			int targetPile = Collections.binarySearch(piles, num);
			if (targetPile < 0)
				targetPile = ~targetPile;
			if (targetPile == piles.size())
				piles.add(num);
			else
				piles.set(targetPile, num);
		}
		return piles.size();
	}
}
