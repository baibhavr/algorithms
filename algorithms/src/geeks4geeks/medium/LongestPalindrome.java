package geeks4geeks.medium;

/**
 * https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1/
 * 
 * @author baibhav <baibhavr@gmail.com> 2:46:45 PM Apr 16, 2022
 */
public class LongestPalindrome {

	String longestPalin(String S) {
		int[] max = new int[] { 1, 0, 0 };
		for (int i = 0; i < S.length(); i++) {
			int[] odd = palindrome(S, i, i);
			int[] even = palindrome(S, i, i + 1);

			if (Math.max(odd[0], even[0]) > max[0]) {
				if (odd[0] > even[0])
					max = odd;
				else
					max = even;
			}
		}
		return S.substring(max[1], max[2] + 1);
	}

	int[] palindrome(String S, int left, int right) {
		if (left < 0 || right >= S.length() || S.charAt(left) != S.charAt(right))
			return new int[] { right - left + 1, left + 1, right - 1 };
		return palindrome(S, left - 1, right + 1);
	}
}
