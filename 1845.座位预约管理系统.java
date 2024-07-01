/*
 * @lc app=leetcode.cn id=1845 lang=java
 *
 * [1845] 座位预约管理系统
 */

// @lc code=start

import java.util.PriorityQueue;

class SeatManager {

    PriorityQueue<Integer> pq;

    public SeatManager(int n) {
        pq = new PriorityQueue<>((a, b) -> (a - b));
        for (int i = 1; i <= n; i++) {
            pq.offer(i);
        }
    }

    public int reserve() {
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
// @lc code=end
