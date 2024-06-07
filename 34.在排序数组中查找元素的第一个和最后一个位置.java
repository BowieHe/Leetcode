/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int left = leftBound(nums, target, 0);
        if (nums[left] != target) {
            return new int[] { -1, -1 };
        }
        int right = leftBound(nums, target + 1, left);
        System.out.println("left:" + left + " right: " + right);
        return new int[] { left, nums[right] == target ? right : right - 1 };
    }

    public int leftBound(int[] nums, int k, int left) {
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;

    }
}
// @lc code=end
