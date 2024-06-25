/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int[] order = new int[nums.length];
        int[] res = new int[nums.length];

        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }

        sort(0, nums.length - 1, index, nums, order, res);

        for (int i = 0; i < nums.length; i++) {
            result.add(res[i]);
        }

        return result;

        // List<Integer> r = new ArrayList<>();
        // for(int i = 0; i >= 0; i-- ) {
        // r.add(res[i]);
        // }

    }

    public void sort(int left, int right, int[] index, int[] nums, int[] order, int[] res) {
        if (left == right) {
            return;
        }

        int mid = left + (right - left) / 2;
        sort(left, mid, index, nums, order, res);
        sort(mid + 1, right, index, nums, order, res);

        // System.out.println("left:" + left + " right:" + right);
        // System.out.println(mid);
        if (nums[index[mid]] <= nums[index[mid + 1]]) {
            return;
        }

        mergeTwo(nums, left, mid, right, index, order, res);
    }

    public void mergeTwo(int[] nums, int left, int mid, int right, int[] index, int[] order, int[] res) {
        for (int i = left; i <= right; i++) {
            order[i] = index[i];
        }

        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                index[k] = order[j];
                j++;
            } else if (j > right) {
                index[k] = order[i];
                i++;
                res[index[k]] += (right - mid);
            } else if (nums[order[i]] <= nums[order[j]]) {
                index[k] = order[i];
                i++;
                res[index[k]] += (j - mid + 1);
            } else {
                index[k] = order[j];
                j++;
            }
        }
    }
}
// @lc code=end
