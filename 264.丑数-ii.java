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
        int[] num = new int[] { 2, 3, 5 };
        Set<Long> set = new HashSet<>();
        Queue<Long> pq = new PriorityQueue<>();
        set.add(1L);
        pq.add(1L);
        for (int i = 1; i < n; i++) {
            long x = pq.poll();

            for (int nu : num) {
                long t = x * nu;
                if (!set.contains(t)) {
                    set.add(t);
                    pq.add(t);
                }
            }

        }
        long res = pq.poll();
        return (int)res;
    }

}
// @lc code=end
