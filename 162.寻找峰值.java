/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int res = check(mid, nums);
            if (res == 0) {
                return mid;
            } else if (res == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            System.out.println("left: " + left + " right:" + right);
        }
        return left;

    }

    int check(int index, int[] nums) {
        boolean left = false, right = false;
        if (index - 1 < 0 || nums[index - 1] < nums[index]) {
            left = true;
        }
        if (index + 1 == nums.length || nums[index] > nums[index + 1]) {
            right = true;
        }

        if (right && left) {
            return 0;
        } else if (left && !right) {
            return 1;
        } else {
            return -1;
        }
    }
}
// @lc code=end
