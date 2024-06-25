/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        int[] res = new int[nums.length];
        sort(nums, 0, nums.length - 1, res);

        return nums;
    }

    public void sort(int[] nums, int left, int right, int[] res) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        sort(nums, left, mid, res);
        sort(nums, mid + 1, right, res);

        if (nums[mid] <= nums[mid + 1]) {
            return;
        }

        merge(nums, left, mid, right, res);
    }

    public void merge(int[] nums, int left, int mid, int right, int[] res) {
        // System.out.print("get origin nums:");
        // Arrays.stream(nums).forEach(System.out::print);
        // System.out.println();
        int i = left, j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                res[index++] = nums[i++];
            } else {
                res[index++] = nums[j++];
            }
        }

        while (i <= mid) {
            res[index++] = nums[i++];
        }

        while (j <= right) {
            res[index++] = nums[j++];
        }
        // System.out.println("get left:" + left + " and right:" + right + " and index;" + index);
        for (int k = 0; k <= right - left; k++) {
            nums[k + left] = res[k];
        }
        // Arrays.stream(nums).forEach(System.out::print);
        // System.out.println();
    }
}
// @lc code=end
