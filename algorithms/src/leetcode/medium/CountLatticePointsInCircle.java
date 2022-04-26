package leetcode.medium;

/**
 * https://leetcode.com/problems/count-lattice-points-inside-a-circle/
 * 
 * @author baibhav <baibhavr@gmail.com> 11:36:05 PM Apr 25, 2022
 */
public class CountLatticePointsInCircle {
	
	public int countLatticePoints(int[][] circles) {
		int ans = 0;
		for (int i = 0; i <= 200; i++) {
			for (int j = 0; j <= 200; j++) {
				for (int[] circle : circles) {
					if (insideCircle(i, j, circle)) {
						ans++;
						break;
					}
				}
			}
		}
		return ans;
	}

	boolean insideCircle(int x, int y, int[] circle) {
		int cx = circle[0], cy = circle[1];
		int r = circle[2];
		
		// bounding box
		int dx = cx - x, dy = cy - y;
		if (Math.abs(dx) > r || Math.abs(dy) > r)
			return false;
		return dx * dx + dy * dy <= r * r;
	}
}
