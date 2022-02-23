package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/subsets/
 * @author baibhav <baibhavr@gmail.com>
 * 6:56:32 PM Nov 26, 2021
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        ans.add(new ArrayList<>());
        backTracking(ans,new ArrayList<>(),0,nums);
        return new ArrayList<>(ans);
    }
    
    void backTracking(Set<List<Integer>> ans, List<Integer> cur, int index, int[] nums){
        
        if(cur.size()==nums.length) return;
        
        for(int i=index;i<nums.length;i++){
            
            int num = nums[i];
            if(cur.contains(num)) continue;
                
            cur.add(num);
            if(!ans.contains(cur))
                ans.add(new ArrayList<Integer>(cur));
            backTracking(ans,cur,i+1,nums);
            cur.remove(new Integer(num));
        }
    }
}
