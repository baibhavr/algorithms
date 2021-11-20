package leetcode.medium;

import java.util.Arrays;

public class SearchRotatedSortedArray {

	public int search(int[] nums, int target) {
	    
		if(nums[0]<=nums[nums.length-1]){
            int answer = Arrays.binarySearch(nums,target);
            return answer>=0 ? answer:-1;
        }
        
        int index = pivotPoint(nums);
        int leftSearch = Arrays.binarySearch(nums,0,index,target);
        if(leftSearch>=0)
            return leftSearch;
        
        int rightSearch = Arrays.binarySearch(nums,index,nums.length,target);
        if(rightSearch>=0)
            return rightSearch;
        
        return -1;
    }
  
    static int pivotPoint(int[] arr){

        if(arr[0]<=arr[arr.length-1]) return arr.length-1;
        int left = 0, right = arr.length-1;
        while(left<right){

            int mid = (left+right)/2;
            if(arr[left]>arr[mid])
                right = mid;
            else if(arr[mid+1]>arr[right])
                left = mid+1;
            else
                return mid+1;
        }
        return -1;
    }
}
