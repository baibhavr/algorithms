package pramp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://www.pramp.com/challenge/MW75pP53wAtzNPVLPG0d
 * @author baibhav <baibhavr@gmail.com>
 * 10:54:14 PM Nov 10, 2021
 */
public class ShortestWordEditPath {
	static int shortestWordEditPath(String source, String target, String[] words) {

		Queue<String> q = new LinkedList<>();
		q.add(source);
		q.add("0");
		int level = 0;
		Set<String> visited = new HashSet<>();

		while (q.size() != 1) {

			String cur = q.remove();

			if (cur.equals("0")) {
				level++;
				q.add(cur);
				continue;
			}

			if (!visited.add(cur))
				continue;

			if (target.equals(cur))
				return level;

			for (String word : words) {

				if (!valid(cur, word))
					continue;

				if (!visited.contains(word))
					q.add(word);
			}
		}
		return -1;
	}

	static boolean valid(String s1, String s2) {

		if (s1.length() != s2.length())
			return false;

		int diff = 0;
		for (int i = 0; i < s1.length(); i++) {

			if (s1.charAt(i) != s2.charAt(i)) {
				diff++;
				if (diff > 1)
					return false;
			}
		}
		return diff == 1;
	}

	public static void main(String[] args) {
		String words[] = new String[] { "but", "put", "big", "pot", "pog", "dog", "lot" };
		System.out.println(shortestWordEditPath("bit", "dog", words));
	}
}
