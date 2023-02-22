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
        if(nums.length == 0) {
            return 0;
        }
        return dp(nums, target, 0);
    }

    Map<String, Integer> memo = new HashMap<String, Integer>();

    int dp(int[] nums, int remains, int index) {
        System.out.println("process index " + index + " remains " + remains);
        if(index == nums.length) {
            return remains == 0? 1: 0;
        }

        String key = index + "," + remains;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
       
        int result = dp(nums, remains - nums[index], index + 1) + dp(nums, remains + nums[index], index + 1);
        memo.put(key, result);
        return result;
    }
}
// @lc code=end

