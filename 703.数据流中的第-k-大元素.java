import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=703 lang=java
 *
 * [703] 数据流中的第 K 大元素
 */

// @lc code=start
class KthLargest {

    int top;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();

        for(int num: nums) {
            pq.offer(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        this.top = k;
    }
    
    public int add(int val) {
        Integer min = pq.peek();
        if(pq.size() < top) {
            pq.offer(val);
            return pq.peek();
        } else if(val <= min){
            return min;
        } else {
            pq.offer(val);
            pq.poll();
            return pq.peek();
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// @lc code=end

