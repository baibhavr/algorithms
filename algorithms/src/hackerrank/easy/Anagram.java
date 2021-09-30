package hackerrank.easy;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/anagram/
 * @author baibhav <baibhavr@gmail.com>
 * 4:33:57 PM Sep 25, 2021
 */
public class Anagram {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedInputStream(System.in));

		int cases = sc.nextInt();
		for (int i = 0; i < cases; i++)
			System.out.println(anagram(sc.next()));
	}

	/*
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
        
        if(s.length()%2!=0) return -1;

        int left = 0, right = s.length()/2;
        int[] count = new int[26];
        while(right<s.length()){
            count[s.charAt(left++)-'a']++;
            count[s.charAt(right++)-'a']--;
        }
        
        int answer = 0;
        for(int i=0;i<26;i++)            
            answer += Math.abs(count[i]);
        return answer/2;
    }
}