package leetcode.medium;

import java.util.LinkedHashMap;

public class LRUCache {

	LinkedHashMap<Integer, Integer> cache;
	int cap;

	public LRUCache(int capacity) {
		cache = new LinkedHashMap<Integer, Integer>(capacity, 1, true);
		cap = capacity;
	}

	public int get(int key) {
		return cache.getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		if (cache.size() == cap && !cache.containsKey(key))
			cache.remove(cache.entrySet().iterator().next().getKey());
		cache.put(key, value);
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */