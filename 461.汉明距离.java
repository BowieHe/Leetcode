/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        //return Integer.bitCount(x ^ y);
        //计算两个二进制数字之间不同的，可以用xor比较方便
        int xor = x ^ y;
        int distance = 0;
        while(xor > 0){
            if((xor & 1 )== 1)
                distance++;
            xor = xor >> 1;
        }
        return distance;
    }
}
// @lc code=end

