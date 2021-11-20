package pramp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.pramp.com/challenge/yZm60L6d5juM7K38KYZ6
 * @author baibhav <baibhavr@gmail.com>
 * 12:51:36 PM Nov 11, 2021
 */
public class NumberOfIslands {

	public static void main(String[] args) {
		
		int[][] binaryMatrix = {{1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 1, 1, 0, 0}, {1, 0, 1, 0, 1}};
		System.out.println(getNumberOfIslands(binaryMatrix));
	}

	static int getNumberOfIslands(int[][] binaryMatrix) {

		int island = 0;

		for (int i = 0; i < binaryMatrix.length; i++) {
			for (int j = 0; j < binaryMatrix[0].length; j++) {

				if (binaryMatrix[i][j] == 1) {
					bfs(binaryMatrix, i, j);
					island++;
				}
			}
		}
		return island;
	}

	static void bfs(int[][] binaryMatrix, int i, int j) {

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j });

		while (q.size() != 0) { // {1,3}

			int[] cur = q.remove(); // [0,3]
			int x = cur[0], y = cur[1];
			if (binaryMatrix[x][y] == 0)
				continue;

			binaryMatrix[x][y] = 0;

			// left
			if (y != 0 && binaryMatrix[x][y - 1] == 1)
				q.add(new int[] { x, y - 1 });

			// right
			if (y != binaryMatrix[0].length - 1 && binaryMatrix[x][y + 1] == 1)
				q.add(new int[] { x, y + 1 });

			// top
			if (x != 0 && binaryMatrix[x - 1][y] == 1)
				q.add(new int[] { x - 1, y });

			// down
			if (x != binaryMatrix.length - 1 && binaryMatrix[x + 1][y] == 1)
				q.add(new int[] { x + 1, y });// {1,3}
		}
	}
}
