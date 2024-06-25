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
        List result = new ArrayList<Integer>();

        int n = nums.length;

        if (n == 0) {
            return result;
        }

        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        int[] temp = new int[n];
        int[] res = new int[n];

        sort(nums, 0, n - 1, index, res, temp);

        for (int r : res) {
            result.add(r);
        }
        return result;
    }

    public void sort(int[] nums, int left, int right, int[] index, int[] res, int[] temp) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        sort(nums, left, mid, index, res, temp);
        sort(nums, mid + 1, right, index, res, temp);

        if (nums[index[mid]] <= nums[index[mid + 1]]) {
            return;
        }

        merge(nums, left, right, mid, index, res, temp);

        // System.out.println("left: " + left + " right:" + right);
        // for (int n : index) {
        // System.out.print(n);
        // }
    }

    public void merge(int[] nums, int left, int right, int mid, int[] index, int[] res, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = index[i];
        }

        System.out.println("left:" + left + " right:" + right);
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                // all left has been synced
                index[k] = temp[j];
                j++;
            } else if (j > right) {
                // rest are all belongs to left, all the right part is smaller than left
                index[k] = temp[i];
                i++;
                res[index[k]] += (right - mid);
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                index[k] = temp[i];
                i++;
                res[index[k]] += (j - mid - 1);
            } else {
                index[k] = temp[j];
                j++;
            }

        }
    }
}
// @lc code=end
