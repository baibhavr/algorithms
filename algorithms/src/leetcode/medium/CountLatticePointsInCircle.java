package leetcode.medium;

/**
 * https://leetcode.com/problems/count-lattice-points-inside-a-circle/
 * 
 * @author baibhav <baibhavr@gmail.com> 11:36:05 PM Apr 25, 2022
 */
public class CountLatticePointsInCircle {
	
	public int countLatticePoints(int[][] circles) {
	       
        // Bounding box for overall search space
        // (i.e. smallest rectangle that covers all the circles)
		
        int xMin=200,xMax=-1,yMin=200,yMax=-1;

        for(int[] c:circles){
            xMin = Math.min(xMin,c[0]-c[2]);
            xMax = Math.max(xMax,c[0]+c[2]);
            
            yMin = Math.min(yMin,c[1]-c[2]);
            yMax = Math.max(yMax,c[1]+c[2]);
        }
        
        int ans = 0;
        
        for(int x=xMin; x<=xMax; x++){
            for(int y=yMin; y<=yMax; y++){
                for(int[] c:circles){
                    if((c[0]-x)*(c[0]-x)+(c[1]-y)*(c[1]-y)<= c[2]*c[2]){ // Inside circle or not?
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
