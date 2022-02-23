package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

class ExpressionAddOperators {
    
    List<String> ans = new ArrayList<>();
    
    public List<String> addOperators(String num, int target) {
        dfs(num,0,target,0,0,"");
        return ans;
    }
    
    void dfs(String num, int pos, int target, long value, long last, String exp){
        
        if(target==value && pos==num.length()){
            ans.add(exp);
        }
        
        for(int end=pos+1;end<=num.length();end++){
            
            if(end-pos>1 && num.charAt(pos)=='0')
                return;
                
            String cur = num.substring(pos,end);
            long cur_val = Long.valueOf(cur);
            if(pos==0){
                dfs(num,end,target,cur_val,cur_val,cur);
            }
            else{
                dfs(num,end,target,value+cur_val,cur_val,exp+"+"+cur);
                dfs(num,end,target,value-cur_val,-cur_val,exp+"-"+cur);
                dfs(num,end,target,value-last+last*cur_val,last*cur_val,exp+"*"+cur);
            }
        }            
    }
}