/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        // int[] dp = new int[len + 1];

        // dp[0] = 0;
        // dp[1] = 0;
        int prev = 0, cur = 0;
        for (int i = 2; i <= len; i++) {

            int next = Math.min(cur + cost[i - 1], prev + cost[i - 2]);
            prev = cur;
            cur = next;

        }

        return cur;
    }
}
// @lc code=end
