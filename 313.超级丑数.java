import java.rmi.dgc.VMID;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 */

// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < m; i++) {
            pq.add(new int[] { primes[i], i, 0 });

        }

        int[] ans = new int[n];
        ans[0] = 1;

        for (int j = 1; j < n;) {
            int[] poll = pq.poll();
            int val = poll[0], i = poll[1], idx = poll[2];
            if (val != ans[j - 1])
                ans[j++] = val;
            pq.add(new int[] { ans[idx + 1] * primes[i], i, idx + 1 });

        }
        return ans[n - 1];
    }
}
// @lc code=end
