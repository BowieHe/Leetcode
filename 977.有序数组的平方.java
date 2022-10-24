/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int len = nums.length - 1, i = 0;
        int[] res = new int[nums.length];
        while(left <= right) {
            if(Math.abs(nums[left]) < Math.abs(nums[right]) ) {
                res[len - i] = nums[right] * nums[right];
                right--;
            } else {
                res[len - i] = nums[left] * nums[left];
                left++;
            }
            i++;
        }

        return res;
    }
}
// @lc code=end

