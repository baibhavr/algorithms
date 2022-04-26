package geeks4geeks.medium;

/**
 * https://practice.geeksforgeeks.org/problems/maximum-index-1587115620/1
 * 
 * @author baibhav <baibhavr@gmail.com> 12:58:25 AM Apr 24, 2022
 */
public class MaximumIndex {
	// A[]: input array
	// N: size of array
	// Function to find the maximum index difference.
	static int maxIndexDiff(int A[], int N) {

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= i && j - i >= ans; j--) {
				if (A[i] <= A[j]) {
					ans = Math.max(ans, j - i);
				}
			}
		}
		return ans;
	}
}
