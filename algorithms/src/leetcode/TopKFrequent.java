package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 * @author baibhav <baibhavr@gmail.com>
 * 2:02:00 PM Sep 30, 2021
 */
public class TopKFrequent {

	public static void main(String[] args) {

	}

	public List<String> topKFrequent(String[] words, int k) {

        PriorityQueue<Map.Entry<String,Integer>> q 
            = new PriorityQueue<>(
                                    (a,b) ->
                                            a.getValue()==b.getValue() ?
                                                b.getKey().compareTo(a.getKey()):
                                                a.getValue()-b.getValue()
                                 );
        
        Map<String,Integer> count = new HashMap<>();
        for(String word:words)
            count.put(word,count.getOrDefault(word,0)+1);
        
        for(Map.Entry<String,Integer> cur:count.entrySet()){
            
            q.add(cur);
            if(q.size()==k+1)
                q.remove();
        }
        
        String[] answer = new String[q.size()];
        while(q.size()!=0)
            answer[q.size()-1] = q.remove().getKey();
        
        return Arrays.asList(answer);
    }

}
