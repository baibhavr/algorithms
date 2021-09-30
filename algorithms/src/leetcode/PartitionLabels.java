package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/partition-labels/
 * 
 * @author baibhav <baibhavr@gmail.com> 2:48:25 PM Sep 30, 2021
 */
public class PartitionLabels {

	public List<Integer> partitionLabels(String s) {

		int[] lastIndex = new int[26];
		for (int i = 0; i < s.length(); i++)
			lastIndex[s.charAt(i) - 'a'] = i;

		List<Integer> answer = new ArrayList<>(Arrays.asList(1));
		int i = 0, maxIndex = -1;
		while (i < s.length()) {

			maxIndex = Math.max(maxIndex, lastIndex[s.charAt(i) - 'a']);

			if (maxIndex == i)
				answer.add(0);

			int answerIndex = answer.size() - 1;
			answer.set(answerIndex, answer.get(answerIndex) + 1);
			i++;
		}

		answer.remove(answer.size() - 1);
		return answer;
	}

}
