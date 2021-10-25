package hackerrank.hard;

import java.util.List;

public class DFSConnectedCell {

	/*
	 * Complete the 'maxRegion' function below.
	 * https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid The
	 * function is expected to return an INTEGER. The function accepts
	 * 2D_INTEGER_ARRAY grid as parameter.
	 */
	public static int maxRegion(List<List<Integer>> grid) {

		int answer = 0;
		for (int i = 0; i < grid.size(); i++)
			for (int j = 0; j < grid.get(0).size(); j++)
				if (grid.get(i).get(j) == 1)
					answer = Math.max(answer, dfs(grid, i, j));
		return answer;
	}

	static int dfs(List<List<Integer>> grid, int i, int j) {

		if (grid.get(i).get(j) == 0)
			return 0;
		grid.get(i).set(j, 0);
		int answer = 1;

		for (int m = i - 1; m <= i + 1; m++)
			if (m >= 0 && m < grid.size())
				for (int n = j - 1; n <= j + 1; n++)
					if (n >= 0 && n < grid.get(0).size() && grid.get(m).get(n) != 0)
						answer += dfs(grid, m, n);
		return answer;
	}
}
