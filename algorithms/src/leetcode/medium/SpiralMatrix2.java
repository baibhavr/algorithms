package leetcode.medium;

public class SpiralMatrix2 {

    int cur = 1;
    public int[][] generateMatrix(int n) {
        
        int[][] answer = new int[n][n];
        
        for(int i=0;i<=n/2;i++)
            traverse(answer,i,n-2*i);
        return answer;
    }
    
    public void traverse(int[][] answer, int i, int len){
        
        // right
        for(int j=i;j<i+len;j++)
            answer[i][j] = cur++;
        
        // down
        for(int j=1;j<len;j++)
            answer[i+j][i+len-1] = cur++;

        // left
        for(int j=i+len-2;j>=i;j--)
            answer[i+len-1][j] = cur++;

        // up
        for(int j=i+len-2;j>i;j--)
            answer[j][i] = cur++;
    }
}
