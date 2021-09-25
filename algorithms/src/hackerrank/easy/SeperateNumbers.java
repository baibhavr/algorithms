package hackerrank.easy;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class SeperateNumbers {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedInputStream(System.in));

		int cases = sc.nextInt();
		for (int i = 0; i < cases; i++)
			separateNumbers(sc.next());
	}

	public static void separateNumbers(String s) {

		int i = 0, firstLen = 1, len = firstLen, nextEnd = 0;
		long cur = 0L, next = 0L;
		while (i + len < s.length() && len <= s.length() / 2 + 1 && len <= 18 && nextEnd <= s.length()) {

			cur = Long.parseLong(s.substring(i, i + len));
			nextEnd = i + len + ((int) Math.log10(cur + 1) + 1);

			if (firstLen == s.length() || nextEnd > s.length())
				break;
			next = Long.parseLong(s.substring(i + len, nextEnd));

			if (cur + 1 != next || (s.charAt(i) == '0' && i > 0) || s.charAt(i + len) == '0') {
				i = 0;
				len = ++firstLen;
			} else {
				i += len;
				len = (int) Math.log10(next) + 1;
			}
		}
		if (cur + 1 == next)
			System.out.println("YES " + s.substring(0, firstLen));
		else
			System.out.println("NO");
	}
}

/* TEST CASES

7
1234
91011
99100
101103
010203
13
1

Expected Output
YES 1
YES 9
YES 99
NO
NO
NO
NO

3
00000000000000000000000000000000
11111111111111111111111111111111
10001001100210031004100510061007

Expected Output
NO
NO
YES 1000

*/
