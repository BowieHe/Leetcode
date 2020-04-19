/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int curr_max = nums[0], sum_max = nums[0];
        for(int i = 1; i < nums.length; i++){
            curr_max = Math.max(nums[i], nums[i] + curr_max);
            sum_max = Math.max(curr_max, sum_max);
        }
        return sum_max;
    }
}
// @lc code=end

