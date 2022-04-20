package geeks4geeks.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://practice.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1#
 * 
 * @author baibhav <baibhavr@gmail.com> 2:57:33 AM Apr 19, 2022
 */
public class SolveSudoku {
	// Function to find a solved Sudoku.
	static boolean SolveSudoku(int grid[][]) {
		int m = grid.length - 1, n = grid[0].length - 1;
		List<int[]> emptyCells = new ArrayList<>();
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (grid[i][j] == 0)
					emptyCells.add(new int[] { i, j });
			}
		}
		return solve(grid, m, n, emptyCells, 0);
	}

	static boolean solve(int[][] grid, int m, int n, List<int[]> emptyCells, int cellId) {

		if (cellId == emptyCells.size())
			return true;

		for (int val = 1; val <= 9; val++) {

			int[] cell = emptyCells.get(cellId);
			if (valid(grid, m, n, cell[0], cell[1], val)) {
				grid[cell[0]][cell[1]] = val;
				if (solve(grid, m, n, emptyCells, cellId + 1))
					return true;
				grid[cell[0]][cell[1]] = 0;
			}
		}
		return false;
	}

	static boolean valid(int[][] grid, int m, int n, int row, int col, int value) {

		for (int i = 0; i <= m; i++)
			if (grid[i][col] == value)
				return false;

		for (int i = 0; i <= n; i++)
			if (grid[row][i] == value)
				return false;

		int startRow = row / 3 * 3;
		int startCol = col / 3 * 3;
		for (int i = startRow; i < startRow + 3 && i <= m; i++) {
			for (int j = startCol; j < startCol + 3 && j <= n; j++) {
				if (grid[i][j] == value)
					return false;
			}
		}
		return true;
	}

	// Function to print grids of the Sudoku.
	static void printGrid(int grid[][]) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(grid[i][j] + " ");
			}
		}
	}
}
