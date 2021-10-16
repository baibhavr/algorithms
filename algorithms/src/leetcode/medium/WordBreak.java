package leetcode.medium;

import java.util.List;

/**
 * https://leetcode.com/problems/word-break/
 * @author baibhav <baibhavr@gmail.com>
 * 5:24:19 AM Oct 12, 2021
 */
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {

		boolean[] valid = new boolean[s.length() + 1];
		valid[0] = true;
		for (int i = 0; i <= s.length(); i++) {

			for (String word : wordDict) {

				if (word.length() <= i && valid[i - word.length()] && word.equals(s.substring(i - word.length(), i))) {
					valid[i] = true;
					break;
				}
			}
		}
		return valid[s.length()];
	}
}
