package leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/goat-latin/
 * @author baibhav <baibhavr@gmail.com>
 * 8:14:00 PM Nov 16, 2021
 */
public class GoatLatin {
	public String toGoatLatin(String sentence) {

		Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		StringBuilder sb = new StringBuilder();
		String suffix = "maa";

		String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; i++) {

			if (vowel.contains(Character.toLowerCase(words[i].charAt(0)))) {
				sb.append(words[i]);
			} else {
				sb.append(words[i].substring(1));
				sb.append(words[i].charAt(0));
			}
			sb.append(suffix);
			if (i != words.length - 1)
				sb.append(" ");
			suffix += "a";
		}
		return sb.toString();
	}
}
