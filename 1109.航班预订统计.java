/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] seat = new int[n + 1];
        for (int[] book : bookings) {
            seat[book[0] - 1] += book[2];
            seat[book[1]] -= book[2];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += seat[i];
            seat[i] = count;
        }

        return Arrays.copyOfRange(seat, 0, seat.length - 1);
    }
}
// @lc code=end
