package hackerrank.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BalancedBrackets {
	
	/*
     * Complete the 'isBalanced' function below.
     * https://www.hackerrank.com/challenges/balanced-brackets
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
	public static String isBalanced(String s) {

		Set<Character> closing = new HashSet<>(Arrays.asList(')', ']', '}'));
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		Stack<Character> stack = new Stack<>();

		for (char ch : s.toCharArray()) {

			if (closing.contains(ch)) {
				if (stack.size() != 0 && stack.peek() == map.get(ch))
					stack.pop();
				else
					return "NO";
			} else
				stack.push(ch);
		}
		return stack.size() == 0 ? "YES" : "NO";
	}
}
