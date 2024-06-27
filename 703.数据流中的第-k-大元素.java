import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=703 lang=java
 *
 * [703] 数据流中的第 K 大元素
 */

// @lc code=start
class KthLargest {

    PriorityQueue<Integer> pq;
    int index;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>((a, b) -> a - b);
        this.index = k;

        for (int n : nums) {
            pq.offer(n);
        }
        while (pq.size() > k) {
            pq.poll();
        }
    }

    int add(int val) {
        pq.offer(val);
        while (pq.size() > this.index) {
            pq.poll();
        }

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// @lc code=end
