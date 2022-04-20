package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
 * 
 * @author baibhav <baibhavr@gmail.com> 2:17:35 AM Apr 20, 2022
 */
public class SubmatricesSum {
	public int numSubmatrixSumTarget(int[][] matrix, int target) {

		// Presum of each row
		int m = matrix.length, n = matrix[0].length, count = 0, sum;
		for (int i = 0; i < m; i++)
			for (int j = 1; j < n; j++)
				matrix[i][j] += matrix[i][j - 1];

		// Check by sliding window and for each row
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {

				sum = 0;
				map.clear(); // <sum,count> stores sum count for this sliding window at different rows
				map.put(0, 1);
				for (int row = 0; row < m; row++) {
					sum += matrix[row][j] - (i != 0 ? matrix[row][i - 1] : 0);
					count += map.getOrDefault(sum - target, 0);
					map.put(sum, map.getOrDefault(sum, 0) + 1);
				}
			}
		}
		return count;
	}
}
