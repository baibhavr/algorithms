package leetcode.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-ii/
 * @author baibhav <baibhavr@gmail.com>
 * 4:00:34 PM Nov 16, 2021
 */
public class NextGreaterElement2 {

	public int[] nextGreaterElements(int[] nums) {

		Stack<Integer> st = new Stack<>();
		int[] ans = new int[nums.length];

		for (int n : new int[] { 0, 1 }) {
			for (int i = nums.length - 1; i >= 0; i--) {

				while (st.size() != 0 && nums[i] >= st.peek()) {
					st.pop();
				}

				if (st.size() != 0)
					ans[i] = st.peek();
				else
					ans[i] = -1;

				st.push(nums[i]);
			}
		}
		return ans;
	}
}
