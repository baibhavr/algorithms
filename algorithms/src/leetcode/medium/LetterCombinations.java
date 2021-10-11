package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinations {

	/**
	 * https://leetcode.com/problems/letter-combinations-of-a-phone-number
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {

		if (digits.length() == 0)
			return new ArrayList<String>();

		String[][] phone = new String[10][];
		phone[2] = new String[] { "a", "b", "c" };
		phone[3] = new String[] { "d", "e", "f" };
		phone[4] = new String[] { "g", "h", "i" };
		phone[5] = new String[] { "j", "k", "l" };
		phone[6] = new String[] { "m", "n", "o" };
		phone[7] = new String[] { "p", "q", "r", "s" };
		phone[8] = new String[] { "t", "u", "v" };
		phone[9] = new String[] { "w", "x", "y", "z" };

		List<String> answer = Arrays.asList(phone[digits.charAt(0) - '0']);

		for (int i = 1; i < digits.length(); i++) {
			int digit = digits.charAt(i) - '0';

			List<String> temp = new ArrayList<>();
			for (String left : answer)
				for (String right : phone[digit])
					temp.add(left + right);

			answer = temp;
		}
		return answer;
	}
}
