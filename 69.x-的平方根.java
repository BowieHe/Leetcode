/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        long left = 0, right = x / 2 + 1;
        while(left < right){
            //所有的计算往右边靠，防止出现死循环的问题
            long mid = (left + right + 1) >> 1;
            long curr = mid * mid;
            if(curr > x)right = mid - 1;
            else left = mid;
        }
        return (int)left;
    }
}
// @lc code=end

