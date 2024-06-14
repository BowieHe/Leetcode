import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                return p1[0] != p2[0] ? p2[0] - p1[0] : p2[1] - p1[1];
            }
        });

        for (int i = 0; i < k; i++) {
            pq.offer(new int[] { nums[i], i });
        }

        int[] res = new int[len - k + 1];
        res[0] = pq.peek()[0];

        for (int i = k; i < len; i++) {
            pq.offer(new int[] { nums[i], i });
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }

            res[i - k + 1] = pq.peek()[0];
        }

        return res;
    }

}
// @lc code=end
