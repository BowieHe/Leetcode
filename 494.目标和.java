import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < target || (sum - target) % 2 != 0)
            return 0;
        int t = (sum - target) / 2;

        int[][] dp = new int[nums.length + 1][t + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= nums.length; i++) {
            int n = nums[i - 1];
            for (int j = 0; j <= t; j++) {

                dp[i][j] = dp[i - 1][j];
                if (j >= n) {
                    dp[i][j] += dp[i - 1][j - n];
                }
            }
        }

        return dp[nums.length][t];
    }
}
// @lc code=end
