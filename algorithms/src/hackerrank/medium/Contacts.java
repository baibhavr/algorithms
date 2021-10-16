package hackerrank.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contacts {

	/*
	 * Complete the 'contacts' function below.
	 * https://www.hackerrank.com/challenges/contacts/problem
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * 2D_STRING_ARRAY queries as parameter.
	 */

	public static List<Integer> contacts(List<List<String>> queries) {

		Map<String, Integer> map = new HashMap<>();

		List<Integer> answer = new ArrayList<>();
		for (List<String> query : queries) {

			String command = query.get(0);
			String str = query.get(1);

			if (command.equals("add")) {
				StringBuilder sub = new StringBuilder();
				for (char ch : str.toCharArray()) {
					sub.append(ch);
					String substring = sub.toString();
					map.put(substring, map.getOrDefault(substring, 0) + 1);
				}
			} else
				answer.add(map.getOrDefault(str, 0));
		}
		return answer;
	}
}
