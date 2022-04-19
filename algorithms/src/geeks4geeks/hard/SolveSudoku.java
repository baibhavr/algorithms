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
	//Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        List<int[]> emptyAt = new ArrayList<>();
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                
                int cur = grid[i][j];
                if(cur==0)
                    emptyAt.add(new int[]{i,j});
            }
        }
        return solve(grid,emptyAt,0);
    }
    
    static boolean solve(int grid[][], List<int[]> emptyAt, int cur){
        
        if(cur==emptyAt.size())
            return true;
        int row = emptyAt.get(cur)[0];
        int col = emptyAt.get(cur)[1];
        
        // candidates for current
        Set<Integer> candidates = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        for(int i=0;i<9;i++){
            candidates.remove(grid[row][i]); // rows
            candidates.remove(grid[i][col]); // cols
        }
        
        int startRow=row/3*3, startCol=col/3*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                candidates.remove(grid[startRow+i][startCol+j]); // square
            }
        }
        
        // use recursion backtracking on candidates
        for(int c:candidates){
            
            grid[row][col] = c;
            if(solve(grid,emptyAt,cur+1))
                return true;
            grid[row][col] = 0;
        }
        return false;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        if(!SolveSudoku(grid)) return;
        
        for(int i=0;i<81;i++)
            System.out.print(grid[i/9][i%9]+" ");
    }
}
