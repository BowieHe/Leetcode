/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int nthUglyNumber(int n) {
        int p2 = 1, p3 = 1, p5 = 1;
        int i2 = 1, i3 = 1, i5 = 1;
        int p = 1;
        int[] res = new int[n + 1];

        while (p <= n) {
            int min = Math.min(p2, Math.min(p3, p5));
            res[p++] = min;

            if (min == p2) {
                p2 = res[i2] * 2;
                i2++;
            }
            if (min == p3) {
                p3 = res[i3] * 3;
                i3++;
            }
            if (min == p5) {
                p5 = res[i5] * 5;
                i5++;
            }

        }

        return res[p - 1];
    }

}
// @lc code=end
