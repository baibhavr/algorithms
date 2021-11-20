package leetcode.medium;

/**
 * https://leetcode.com/problems/palindromic-substrings/
 * @author baibhav <baibhavr@gmail.com>
 * 11:30:02 AM Nov 20, 2021
 */
public class PalindromicSubstrings {
	public int countSubstrings(String s) {
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			ans += palindromes(s, i, i);
			ans += palindromes(s, i, i + 1);
		}
		return ans;
	}

	int palindromes(String s, int left, int right) {
		int count = 0;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			count++;
			left--;
			right++;
		}
		return count;
	}
}
