package hackerrank.easy;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class GemStones {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedInputStream(System.in));

		int cases = sc.nextInt();
		List<String> arr = new ArrayList<>();
		for (int i = 0; i < cases; i++)
			arr.add(sc.next());

		System.out.println(gemstones(arr));
	}

	/**
	 * Complete the 'gemstones' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * STRING_ARRAY arr as parameter.
	 */
	public static int gemstones(List<String> arr) {

		int[] count = new int[26];
		for (String s : arr) {
			Set<Character> set = new HashSet<>();
			for (char ch : s.toCharArray())
				if (set.add(ch))
					count[ch - 'a']++;
		}

		int ans = 0;
		for (int i = 0; i < 26; i++)
			if (count[i] == arr.size())
				ans++;
		return ans;
	}
}

/* TEST CASES

3
abcdde
baccd
eeabg

arr[] size n = 3
arr = ['abcdde', 'baccd', 'eeabg']

Expected Output
2

*/
