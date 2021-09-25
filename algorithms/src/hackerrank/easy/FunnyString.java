package hackerrank.easy;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class FunnyString {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedInputStream(System.in));

		int cases = sc.nextInt();
		for (int i = 0; i < cases; i++)
			System.out.println(funnyString(sc.next()));
	}

	/**
	 * Determine whether a string is funny or not. To determine whether a string is
	 * funny, create a copy of the string in reverse e.g. Iterating through each
	 * string, compare the absolute difference in the ascii values of the characters
	 * at positions 0 and 1, 1 and 2 and so on to the end. If the list of absolute
	 * differences is the same for both strings, they are funny. Determine whether a
	 * give string is funny. If it is, return Funny, otherwise return Not Funny.
	 * 
	 * @param s
	 * @return
	 */
	public static String funnyString(String s) {

		for (int i = 0; i < Math.ceil(s.length() / 2.0) - 1; i++)
			if (Math.abs(s.charAt(i) - s.charAt(i + 1)) != Math
					.abs(s.charAt(s.length() - 1 - i) - s.charAt(s.length() - 2 - i)))
				return "Not Funny";
		return "Funny";
	}
}

/* TEST CASES

2
ivvkxq
ivvkx

Expected Output
Not Funny
Not Funny

2
acxz
bcxz

Expected Output
Funny
Not Funny

*/
