package geeks4geeks.hard;

import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
 * 
 * @author baibhav <baibhavr@gmail.com> 1:22:32 AM Apr 17, 2022
 */
public class MergeWithoutExtraSpace {

	public static void merge(long arr1[], long arr2[], int n, int m) {
		int one = n - 1, two = 0;

		while (one >= 0 && two < m) {

			if (arr2[two] < arr1[one]) {
				// Swap
				long temp = arr1[one];
				arr1[one] = arr2[two];
				arr2[two] = temp;
			}
			one--;
			two++;
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
	}
}
