package hackerrank.easy;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/palindrome-index/problem
 * @author baibhav <baibhavr@gmail.com>
 * 4:15:37 PM Sep 25, 2021
 */
public class PalindromeIndex {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedInputStream(System.in));

		int cases = sc.nextInt();
		for (int i = 0; i < cases; i++)
			System.out.println(palindromeIndex(sc.next()));
	}

	/*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {
    
        int left = 0, right = s.length()-1;
        
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                
                if(palindrome(s,left,right-1))// skip right char
                    return right;
                else if(palindrome(s,left+1,right))// skip left char
                    return left;
                else
                    return -1;
            }
            left++;right--;
        }
        return -1;
    }
    
    static boolean palindrome(String s, int left, int right){
        while(left<right && s.charAt(left)==s.charAt(right)){
            left++;
            right--;
        }
        return left<right ? false:true;
    }
}

/* TEST CASES

3
aaab
baa
aaa

Expected Output
3
0
-1

*/
