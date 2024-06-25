/*
 * @lc app=leetcode.cn id=1094 lang=java
 *
 * [1094] 拼车
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 0;
        for (int[] t : trips) {
            max = Math.max(max, t[2]);
        }

        int[] diff = new int[max + 1];
        for (int[] t : trips) {
            diff[t[1]] += t[0];
            diff[t[2]] -= t[0];
        }

        int count = 0;
        for (int i = 0; i < max; i++) {
            count += diff[i];
            if (count > capacity) {
                return false;
            }
        }

        return true;

    }
}
// @lc code=end
