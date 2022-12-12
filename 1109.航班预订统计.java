/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Diff df = new Diff(nums);

        for(int[] book: bookings) {
            int i = book[0] - 1;
            int j = book[1] - 1;
            int val = book[2];
             df.incr(i, j, val);
        }
        return df.results();
    }

    class Diff {
        private int[] diff;

        Diff(int[] nums) {
            this.diff = new int[nums.length];
            diff[0] = nums[0];
            for(int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        void incr(int i, int j, int val) {
            diff[i] += val;
            if(j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        int[] results() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for(int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
}
// @lc code=end

