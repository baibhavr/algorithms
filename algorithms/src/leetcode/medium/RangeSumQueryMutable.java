package leetcode.medium;

/**
 * https://leetcode.com/submissions/detail/574787863/
 * @author baibhav <baibhavr@gmail.com>
 * 5:01:58 AM Oct 21, 2021
 */
public class RangeSumQueryMutable {
	Node root;
    
    public RangeSumQueryMutable(int[] nums) {
        root = new Node(0,0,nums.length-1); 
        constructSegmentTree(nums,root);
    }
    
    void constructSegmentTree(int[] nums, Node cur){
        
        if(cur.start==cur.end){
            cur.val = nums[cur.start];
            return;
        }
        
        int mid = (cur.start+cur.end)/2;
        cur.left = new Node(0,cur.start,mid);
        cur.right = new Node(0,mid+1,cur.end);
        constructSegmentTree(nums,cur.left);
        constructSegmentTree(nums,cur.right);
        cur.val = cur.left.val+cur.right.val;
    }
    
    public void update(int index, int val) {
        updateHelper(root,index,val);
    }
    
    public void updateHelper(Node cur, int index, int val){

        if(index<cur.start || index>cur.end)
            return;
        if(cur.start==cur.end){
            cur.val = val;
            return;
        }
        updateHelper(cur.left,index,val);
        updateHelper(cur.right,index,val);
        cur.val = cur.left.val+cur.right.val;
    }
    
    public int sumRange(int left, int right) {
        return sumHelper(root,left,right);        
    }
    
    int sumHelper(Node cur, int i, int j){
        if(cur.start==i && cur.end==j)
            return cur.val;
        
        int mid = (cur.start+cur.end)/2;
        if(i>mid)
            return sumHelper(cur.right,i,j);
        else if(j<=mid)
            return sumHelper(cur.left,i,j);
        return sumHelper(cur.left,i,mid)+sumHelper(cur.right,mid+1,j);
    }
    
    class Node{
        int val,start,end;
        Node left,right;
        Node(int v,int i,int j){
            val = v; start = i; end = j;
        }
    }
}
