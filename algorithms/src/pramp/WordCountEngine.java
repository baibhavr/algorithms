package pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * https://www.pramp.com/challenge/W5EJq2Jld3t2ny9jyZXG
 * @author baibhav <baibhavr@gmail.com> 
 * 12:17:27 PM Nov 11, 2021
 */
public class WordCountEngine {

	/**
	 * Count {practice:3,just:1,by:1,perfect:2,get:1,only:1,youll:1,makes:1}
	 * Ordered
	 * { 	1: makes,youll,only,get,by,just 
	 * 		2: perfect
	 * 		3: practice 
	 * }
	 */
	static String[][] wordCountEngine(String document) {

		String[] words = document.replaceAll("\\p{P}", "").toLowerCase().split("\\s+");

		Map<String, Integer> count = new HashMap<>();
		Map<Integer, LinkedHashSet<String>> ordered = new LinkedHashMap<>();

		for (int i = words.length - 1; i != -1; i--) {

			String word = words[i];
			if (count.containsKey(word)) {

				int freq = count.get(word);
				count.put(word, freq + 1);
				ordered.get(freq++).remove(word);

				if (!ordered.containsKey(freq))
					ordered.put(freq, new LinkedHashSet<String>());
				ordered.get(freq).add(word);
			} else {
				count.put(word, 1);
				if (!ordered.containsKey(1))
					ordered.put(1, new LinkedHashSet<String>());
				ordered.get(1).add(word);
			}
		}

		String[][] ans = new String[count.size()][];
		int index = 0;
		for (int i = words.length - 1; i > 0; i--) {

			if (ordered.containsKey(i) && ordered.get(i).size() != 0) {

				String freq = i + "";
				List<String> list = new ArrayList<>(ordered.get(i));
				Collections.reverse(list);
				for (String w : list)
					ans[index++] = new String[] { w, freq };
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		String[][] ans = wordCountEngine("Practice makes perfect. you'll only get Perfect by practice. just practice!");

		for (String[] tuple : ans)
			System.out.println(Arrays.asList(tuple));
	}
}
