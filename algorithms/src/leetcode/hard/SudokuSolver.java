package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sudoku-solver/
 * 
 * @author baibhav <baibhavr@gmail.com> 3:00:21 AM Apr 20, 2022
 */
public class SudokuSolver {
	public void solveSudoku(char[][] board) {

		// Finds empty cells
		List<int[]> emptyCells = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					emptyCells.add(new int[] { i, j });
			}
		}

		solve(board, emptyCells, 0);
	}

	/**
	 * Uses backtracking to find the solution
	 */
	boolean solve(char[][] board, List<int[]> emptyCells, int emptyId) {

		if (emptyId == emptyCells.size())
			return true;

		for (int val = 1; val <= 9; val++) {

			int[] cell = emptyCells.get(emptyId);
			char candidate = (char) (val + '0');

			if (valid(board, cell, candidate)) {

				board[cell[0]][cell[1]] = candidate;
				if (solve(board, emptyCells, emptyId + 1))
					return true;

				board[cell[0]][cell[1]] = '.';
			}
		}
		return false;
	}

	/**
	 * Time can be improved. Use sets to quickly check if value is valid
	 * @param board
	 * @param cell
	 * @param value
	 * @return
	 */
	boolean valid(char[][] board, int[] cell, char value) {

		// Check if duplicate exists in the same row and col
		for (int i = 0; i < 9; i++) {
			if (board[cell[0]][i] == value)
				return false;
			if (board[i][cell[1]] == value)
				return false;
		}

		// Check if duplicate exists in the same square
		int startRow = (cell[0] / 3) * 3;
		int startCol = (cell[1] / 3) * 3;
		for (int i = startRow; i < startRow + 3 && i < 9; i++) {
			for (int j = startCol; j < startCol + 3 && j < 9; j++) {
				if (board[i][j] == value)
					return false;
			}
		}

		return true;
	}
}
