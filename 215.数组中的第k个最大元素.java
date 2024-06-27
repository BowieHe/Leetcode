import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n: nums) {
            pq.offer(n);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
// @lc code=end
