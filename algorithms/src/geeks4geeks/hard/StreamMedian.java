package geeks4geeks.hard;

import java.util.PriorityQueue;

/**
 * https://practice.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1#
 * @author baibhav <baibhavr@gmail.com>
 * 7:07:13 PM Apr 17, 2022
 */
public class StreamMedian {

	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    //Function to insert heap.
    public static void insertHeap(int x) {
        maxHeap.add(x);
        balanceHeaps();
    }
    
    //Function to balance heaps.
    public static void balanceHeaps() {
        while(maxHeap.size()!=0 && minHeap.size()!=0 && maxHeap.peek()>minHeap.peek()){
            minHeap.add(maxHeap.remove());
            maxHeap.add(minHeap.remove());
        }
        while(maxHeap.size()-minHeap.size()>1)
            minHeap.add(maxHeap.remove());
    }
    
    //Function to return Median.
    public static double getMedian() {
        if(maxHeap.size()>minHeap.size())
            return maxHeap.peek();
        return (maxHeap.peek()+minHeap.peek())/2.0;
    }
}
