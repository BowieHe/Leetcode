/*
 * @lc app=leetcode.cn id=1845 lang=java
 *
 * [1845] 座位预约管理系统
 */

// @lc code=start
class SeatManager {

    int[] seats;
    int minSeat;

    public SeatManager(int n) {
        seats = new int[n];
        minSeat = 0;
    }
    
    public int reserve() {
        while(seats[minSeat] != 0) {
            minSeat++;
        }
        seats[minSeat] = 1;
        return ++minSeat;
    }
    
    public void unreserve(int seatNumber) {
        minSeat = Math.min(minSeat, seatNumber - 1);
        seats[seatNumber - 1] = 0;
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
// @lc code=end

