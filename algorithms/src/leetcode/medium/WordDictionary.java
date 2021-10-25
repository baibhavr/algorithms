package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure
 * @author baibhav <baibhavr@gmail.com>
 * 6:43:45 PM Oct 19, 2021
 */
public class WordDictionary {
	/** Initialize your data structure here. */
    Map<Integer,List<String>> map;
    public WordDictionary() {
        map = new HashMap<>();
    }
    
    public void addWord(String word) {
        int len = word.length();
        if(!map.containsKey(len))
            map.put(len,new ArrayList<>());
        map.get(len).add(word);
    }
    
    public boolean search(String word) {
        
        int len = word.length();
        if(!map.containsKey(len))
            return false;
        
        for(String dict:map.get(len))
            if(sameWords(dict,word))
                return true;
        return false;
    }
    
    public boolean sameWords(String dict,String pattern){
        for(int i=0;i<dict.length();i++)
            if(pattern.charAt(i)!='.' && dict.charAt(i)!=pattern.charAt(i))
                return false;
        return true;
    }
}
