package leetcode.hard;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/submissions/detail/668254049/ 1:32:33 PM Mar 28, 2022
 */
public class WordLadder {

	/**
	 * 2 way BFS
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

		Set<String> words = new HashSet<>(wordList), visited = new HashSet<>();

		if (!words.contains(endWord))
			return 0;

		Set<String> beginSet = new HashSet<>();
		Set<String> endSet = new HashSet<>();
		beginSet.add(beginWord);
		endSet.add(endWord);

		int ans = 1;

		while (beginSet.size() != 0 && endSet.size() != 0) {
			Set<String> nextLevel = new HashSet<>();

			// check smaller set first, swap if beginSet is bigger
			if (beginSet.size() > endSet.size()) {
				Set<String> temp = beginSet;
				beginSet = endSet;
				endSet = temp;
			}

			for (String cur : beginSet) {

				// Check neighbors of cur
				char[] sb = cur.toCharArray(); // building String
				for (int i = 0; i < sb.length; i++) {

					char old = sb[i];
					for (int update = 'a'; update <= 'z'; update++) {

						if (old == update)
							continue;
						sb[i] = (char) update;
						String nb = String.valueOf(sb);

						if (endSet.contains(nb)) // if true other BFS already visited the node
							return ++ans;

						if (words.contains(nb) && !visited.contains(nb)) { // if true this is the neighbor
							visited.add(nb);
							nextLevel.add(nb);
						}
					}
					sb[i] = old;
				}
			}
			beginSet = nextLevel;
			ans++;
		}
		return 0;
	}

	/**
	 * 1 way BFS
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength1(String beginWord, String endWord, List<String> wordList) {

		Set<String> words = new HashSet<>(wordList), visited = new HashSet<>();

		Set<String> beginSet = new HashSet<>();
		beginSet.add(beginWord);

		int ans = 2;

		while (beginSet.size() != 0) {

			Set<String> nextLevel = new HashSet<>();
			for (String cur : beginSet) {

				// Check neighbors of cur
				char[] sb = cur.toCharArray(); // building String
				for (int i = 0; i < sb.length; i++) {

					char old = sb[i];
					for (int update = 'a'; update <= 'z'; update++) {

						sb[i] = (char) update;
						String nb = String.valueOf(sb);
						if (words.contains(nb) && !visited.contains(nb)) { // if true this is the neighbor

							if (nb.equals(endWord))
								return ans;

							visited.add(nb);
							nextLevel.add(nb);
						}
					}
					sb[i] = old;
				}
			}
			beginSet = nextLevel;
			ans++;
		}
		return 0;
	}
}
