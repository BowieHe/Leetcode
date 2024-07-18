/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 */

// @lc code=start

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int len = points.length;
        // int[] res = new int[len];

        if (points.length <= 2) {
            return len;
        }
        int max = 0;

        for (int i = 0; i < len; i++) {
            int[] p = points[i];
            Map<Integer, Integer> r = new HashMap<>();

            for (int j = i + 1; j < len; j++) {
                int[] follow = points[j];
                int x = follow[0] - p[0];
                int y = follow[1] - p[1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    int num = gcd(x, y);
                    x /= num;
                    y /= num;
                }

                int a = y + x * (20001);
                int c = r.getOrDefault(a, 1);
                max = Math.max(c + 1, max);
                r.put(a, c + 1);
            }
        }

        return max;

    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
// @lc code=end
