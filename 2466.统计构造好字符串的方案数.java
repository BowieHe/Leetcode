/*
 * @lc app=leetcode.cn id=2466 lang=java
 *
 * [2466] 统计构造好字符串的方案数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        Arrays.fill(dp, -1);
        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans = (ans + dfs(i, zero, one, dp)) % MOD;
        }

        return ans;

    }

    private int dfs(int n, int zero, int one, int[] dp) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = (dfs(n - zero, zero, one, dp) + dfs(n - one, zero, one, dp)) % MOD;
    }
}
// @lc code=end
