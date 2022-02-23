package leetcode.medium;

/**
 * https://leetcode.com/problems/product-of-array-except-self
 * @author baibhav <baibhavr@gmail.com>
 * 6:48:44 PM Nov 26, 2021
 */
public class ProductExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] left = new int[len];
		int[] right = new int[len];

		left[0] = nums[0];
		right[len - 1] = nums[len - 1];
		for (int i = 1; i < len; i++) {
			left[i] = left[i - 1] * nums[i];
			right[len - i - 1] = right[len - i] * nums[len - i - 1];
		}

		int[] ans = new int[len];
		ans[0] = right[1];
		ans[len - 1] = left[len - 2];
		for (int i = 1; i < len - 1; i++) {
			ans[i] = left[i - 1] * right[i + 1];
		}
		return ans;
	}
}
