/*
 * @lc app=leetcode.cn id=327 lang=java
 *
 * [327] 区间和的个数
 */

// @lc code=start
class Solution {

    int lower, upper;

    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
        sort(sum);
        
    }
}
// @lc code=end
