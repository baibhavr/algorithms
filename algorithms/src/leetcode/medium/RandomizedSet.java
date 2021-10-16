package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	Map<Integer, Integer> map; // <Val,Index>
	List<Integer> al; // <Val>
	Random r;

	public RandomizedSet() {
		map = new HashMap<>();
		al = new ArrayList<>();
		r = new Random();
	}

	public boolean insert(int val) {
		if (!map.containsKey(val)) {
			al.add(val);
			map.put(val, al.size() - 1);
			return true;
		}
		return false;
	}

	public boolean remove(int val) {

		if (map.containsKey(val)) { // Swap with the last element of the list
			int last = al.get(al.size() - 1);
			al.set((int) map.get(val), last);
			map.put(last, (int) map.get(val));
			al.remove(al.size() - 1);
			map.remove(val);
			return true;
		}
		return false;
	}

	public int getRandom() {
		return al.get(r.nextInt(al.size()));
	}
}
