package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * @author baibhav <baibhavr@gmail.com>
 * 3:15:45 PM Oct 5, 2021
 */
public class ShortestPathBinaryMatrix {

	public int shortestPathBinaryMatrix(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        q.add(new int[]{-1});
        int distance = 1;
        
        while(q.size()!=1){
            int[] cur = q.remove();
            
            if(cur[0]==-1){
                distance++;
                q.add(cur);
                continue;
            }
            int i = cur[0], j = cur[1];
            if(grid[i][j]==1) continue;
            
            grid[i][j] = 1;
            
            if(i==grid.length-1 && j==grid[0].length-1)
                return distance;
            // checks and enqueue all 3x3 block
            enqueue(q,grid,i,j);
        }
        return -1;
    }
    
    void enqueue(Queue<int[]> q, int[][] grid, int r, int c){
        
        int m=grid.length, n = grid[0].length;
        
        for(int i=r-1;i<=r+1;i++){
            for(int j=c-1;j<=c+1;j++){
                if(i<0 || i>=m) continue;
                if(j<0 || j>=n) continue;
                if(i==r && j==c) continue;
                if(grid[i][j]==0)
                    q.add(new int[]{i,j});
            }
        }
    }
}
