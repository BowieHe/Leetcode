/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        // int len = nums.length;
        // if (target < nums[0]) {
        // for (int i = len - 1; i >= 0 && target <= nums[i]; i--) {
        // if (nums[i] == target) {
        // return true;
        // }
        // }
        // } else {
        // for (int i = 0; i < len && target >= nums[i]; i++) {
        // if (nums[i] == target) {
        // return true;
        // }
        // }
        // }
        // return false;

        int left = 0, right = nums.length - 1;

        if (nums.length == 0)
            return false;
        if (nums.length == 1 && nums[0] == target)
            return true;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else {
                if (nums[left] <= nums[mid]) {
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }

                } else {
                    if (nums[mid] < target && target <= nums[nums.length - 1]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }

        }

        return false;

    }
}
// @lc code=end
