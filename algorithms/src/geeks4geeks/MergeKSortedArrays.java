package geeks4geeks;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/
 * @author baibhav <baibhavr@gmail.com>
 * 9:53:01 PM Oct 12, 2021
 */
public class MergeKSortedArrays {
	
	// Function to merge k sorted arrays.
	public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {

		ArrayList<Integer> answer = new ArrayList<>();

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> arr[a[0]][a[1]] - arr[b[0]][b[1]]);
		for (int i = 0; i < arr.length; i++)
			pq.add(new int[] { i, 0 });

		while (pq.size() != 0) {

			int[] cur = pq.remove();
			answer.add(arr[cur[0]][cur[1]]);

			cur[1]++;
			if (cur[1] < arr[cur[0]].length)
				pq.add(cur);
		}
		return answer;
	}
}
