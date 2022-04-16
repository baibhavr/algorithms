package leetcode.medium;

/**
 * https://leetcode.com/problems/maximal-square/
 * 
 * @author baibhav <baibhavr@gmail.com> 4:39:12 AM Apr 16, 2022
 */
public class MaximalSquare {
	public int maximalSquare(char[][] mat) {

		int[] upperRow = new int[mat[0].length];
		int max = 0;

		for (int i = 0; i < mat.length; i++) {
			int[] curRow = new int[mat[0].length];

			for (int j = 0; j < mat[0].length; j++) {
				helper(mat, upperRow, curRow, i, j);
				max = Math.max(max, curRow[j]);
			}
			upperRow = curRow;
		}
		return max * max;
	}

	void helper(char[][] mat, int[] upperRow, int[] curRow, int row, int col) {

		if (row == 0 || col == 0) {
			curRow[col] = mat[row][col] - '0';
			return;
		}

		int min = mat[row][col] - '0';

		if (min != 0)
			min = Math.min(Math.min(upperRow[col - 1], upperRow[col]), curRow[col - 1]) + 1;
		curRow[col] = min;
	}
}
