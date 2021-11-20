package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement1 {

	/**
	 * https://leetcode.com/problems/next-greater-element-i/
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums2.length; i++) {
			map.put(nums2[i], i);
		}

		int[] ans = new int[nums1.length];
		int ansIndex = 0;
		for (int num : nums1) {

			int index = map.get(num);

			for (; index < nums2.length; index++) {
				if (nums2[index] > num)
					break;
			}

			if (index < nums2.length)
				ans[ansIndex++] = nums2[index];
			else
				ans[ansIndex++] = -1;
		}
		return ans;
	}
}
