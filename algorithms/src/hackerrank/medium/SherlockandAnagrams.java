package hackerrank.medium;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SherlockandAnagrams {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedInputStream(System.in));

		int cases = sc.nextInt();
		for (int i = 0; i < cases; i++)
			System.out.println(sherlockAndAnagrams(sc.next()));
	}

	/**
	 * Complete the 'sherlockAndAnagrams' function below.
	 * Two strings are anagrams of each other if the letters of one string can be 
	 * rearranged to form the other string. Given a string, find the number of pairs 
	 * of substrings of the string that are anagrams of each other.	
	 * The function is expected to return an INTEGER. The function accepts STRING s
	 * as parameter.
	 */
	public static int sherlockAndAnagrams(String s) {

		int answer = 0;
		for (int i = 0; i < s.length(); i++) {

			int[] curSet = new int[26];

			for (int j = i + 1; j <= s.length(); j++) {

				curSet[s.charAt(j - 1) - 'a']++;

				for (int x = i + 1; x < s.length() - (j - i) + 1; x++) {
					String next = s.substring(x, x + (j - i));
					int[] nextSet = new int[26];

					for (char ch : next.toCharArray())
						nextSet[ch - 'a']++;

					if (Arrays.equals(curSet, nextSet))
						answer++;
				}
			}
			curSet[s.charAt(i) - 'a']--;
		}
		return answer;
	}
}

/*
	Sample Input 0
	2
	abba
	abcd
	
	Sample Output 0
	4
	0
	
	Sample Input 1
	2
	ifailuhkqq
	kkkk
	
	Sample Output 1
	3
	10
*/
