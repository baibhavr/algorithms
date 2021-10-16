package leetcode.medium;

import java.util.Arrays;

public class CoinChange {
	int[] dp;

	public int coinChange(int[] coins, int amount) {

		dp = new int[amount + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;

		for (int i = 1; i <= amount; i++)
			dp[i] = helper(coins, i);

		return dp[amount] == -1 ? -1 : dp[amount];
	}

	public int helper(int[] coins, int amount) {

		int min = 10001;
		for (int coin : coins) {
			int prev = amount - coin;
			if (prev >= 0 && dp[prev] != -1)
				min = Math.min(min, dp[prev]);
		}
		return min == 10001 ? -1 : 1 + min;
	}
}
