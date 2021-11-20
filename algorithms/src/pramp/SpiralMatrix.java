package pramp;

/**
 * https://www.pramp.com/challenge/ml9AwEA42YHK735G3lq5
 * @author baibhav <baibhavr@gmail.com>
 * 12:50:21 PM Nov 11, 2021
 */
public class SpiralMatrix {
	static int[] spiralCopy(int[][] inputMatrix) {

		int[] rowRange = new int[] { 0, inputMatrix.length - 1 };
		int[] colRange = new int[] { 0, inputMatrix[0].length - 1 };

		int row = 0, col = 0, index = 0;

		int[] ans = new int[inputMatrix.length * inputMatrix[0].length];

		while (index < ans.length) {

			// top
			while (index < ans.length && col <= colRange[1]) {
				ans[index++] = inputMatrix[row][col++];
			}

			// right
			row++;
			col--;
			while (index < ans.length && row < rowRange[1]) {
				ans[index++] = inputMatrix[row++][col];
			}

			// bottom
			while (index < ans.length && col >= colRange[0]) {
				ans[index++] = inputMatrix[row][col--];
			}

			// left
			col++;
			row--;
			while (index < ans.length && row > rowRange[0]) {
				ans[index++] = inputMatrix[row--][col];
			}

			rowRange[0]++;
			rowRange[1]--;
			colRange[0]++;
			colRange[1]--;
			row = rowRange[0];
			col = colRange[0];
		}
		return ans;
	}
}
