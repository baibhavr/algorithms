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

	/**
	 * Function to find a solved Sudoku.
	 * 
	 * @param grid
	 * @return
	 */
	static boolean SolveSudoku(int grid[][]) {
		List<int[]> emptyCells = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid[i][j] == 0)
					emptyCells.add(new int[] { i, j });
			}
		}
		return solve(grid, emptyCells, 0);
	}

	/**
	 * Checks if any sets of values can be inserted into empty cells to get a valid
	 * solution Using backtracking
	 * 
	 * @param grid
	 * @param m
	 * @param n
	 * @param emptyCells
	 * @param cellId
	 * @return
	 */
	static boolean solve(int[][] grid, List<int[]> emptyCells, int cellId) {

		if (cellId == emptyCells.size())
			return true;

		for (int val = 1; val <= 9; val++) {

			int[] cell = emptyCells.get(cellId);
			if (valid(grid, cell[0], cell[1], val)) {
				grid[cell[0]][cell[1]] = val;
				if (solve(grid, emptyCells, cellId + 1))
					return true;
				grid[cell[0]][cell[1]] = 0;
			}
		}
		return false;
	}

	/**
	 * Check if current value is valid to be inserted in the cell(row,col)
	 * 
	 * @param grid
	 * @param m
	 * @param n
	 * @param row
	 * @param col
	 * @param value
	 * @return
	 */
	static boolean valid(int[][] grid, int row, int col, int value) {

		for (int i = 0; i < 9; i++)
			if (grid[i][col] == value)
				return false;

		for (int i = 0; i < 9; i++)
			if (grid[row][i] == value)
				return false;

		int startRow = row / 3 * 3;
		int startCol = col / 3 * 3;
		for (int i = startRow; i < startRow + 3 && i < 9; i++) {
			for (int j = startCol; j < startCol + 3 && j < 9; j++) {
				if (grid[i][j] == value)
					return false;
			}
		}
		return true;
	}

	/**
	 * Function to print grids of the Sudoku.
	 * 
	 * @param grid
	 */
	static void printGrid(int grid[][]) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(grid[i][j] + " ");
			}
		}
	}
}
