package algorithms;

import java.util.LinkedHashMap;

public class LRUCacheLinkedHashMap {

	LinkedHashMap<Integer,Integer> cache;
    int cap;
    public LRUCacheLinkedHashMap(int capacity) {
        cap = capacity;
        cache = new LinkedHashMap<Integer,Integer>(cap,1.1f,true);
    }
    
    public int get(int key) {
        return cache.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        if(!cache.containsKey(key) && cache.size()==cap)
            cache.remove(cache.entrySet().iterator().next().getKey()); // removes not recently used item
        cache.put(key,value);
    }

}
