/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for(int bitlocation = 31; n != 0; bitlocation--,n = n>>>1){
            ans += (n & 1)<< bitlocation;
        }
        return ans;
    }
}
// @lc code=end

