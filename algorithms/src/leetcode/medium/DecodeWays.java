package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
	
	public int numDecodings(String s) {
		int[] ans = new int[1];
		Map<Integer, Integer> mem = new HashMap<>();
		mem.put(s.length(), 1);
		dfs(s, 0, ans, mem);
		return ans[0];
	}

	void dfs(String s, int pos, int[] ans, Map<Integer, Integer> mem) {

		if (mem.containsKey(pos)) {
			ans[0] += mem.get(pos);
			return;
		}

		if (s.charAt(pos) == '0')
			return;

		int old = ans[0];

		dfs(s, pos + 1, ans, mem);
		if (pos + 2 <= s.length() && Integer.valueOf(s.substring(pos, pos + 2)) <= 26)
			dfs(s, pos + 2, ans, mem);

		mem.put(pos, ans[0] - old);
	}
}
