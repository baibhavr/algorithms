package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * @author baibhav <baibhavr@gmail.com>
 * 12:03:59 AM Nov 21, 2021
 */
public class IntersectionofArrays {
	public int[] intersection(int[] nums1, int[] nums2) {

		Set<Integer> vals = new HashSet<Integer>();
		Set<Integer> ans = new HashSet<>();

		for (int num1 : nums1)
			vals.add(num1);
		for (int num2 : nums2)
			if (vals.contains(num2))
				ans.add(num2);

		int[] ansArray = new int[ans.size()];
		int i = 0;
		for (int num : ans)
			ansArray[i++] = num;
		return ansArray;
	}
}
