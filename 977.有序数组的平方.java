/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int index = nums.length - 1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                res[index] = nums[right] * nums[right];
                right--;
            } else {
                res[index] = nums[left] * nums[left];
                left++;
            }
            index--;
        }

        return res;

    }
}
// @lc code=end
