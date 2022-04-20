package leetcode.hard;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/prefix-and-suffix-search/
 * 
 * @author baibhav <baibhavr@gmail.com> 2:22:32 AM Apr 20, 2022
 */
public class PrefixSuffixSearch {
	HashMap<String, Integer> map;

	public void WordFilter(String[] words) {
		map = new HashMap<String, Integer>();

		// for every word
		for (int i = 0; i < words.length; i++) {

			String word = words[i];
			// for every prefix
			for (int j = 1; j < word.length() + 1; j++) {

				String prefix = word.substring(0, j);
				// for every suffix
				for (int k = 0; k < word.length(); k++) {
					String suffix = word.substring(k);
					map.put(prefix + "#" + suffix, i);
				}
			}
		}
	}

	public int f(String prefix, String suffix) {
		return map.getOrDefault(prefix + "#" + suffix, -1);
	}
}
