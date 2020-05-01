/*
 * @lc app=leetcode.cn id=476 lang=java
 *
 * [476] 数字的补数
 */

// @lc code=start
class Solution {
    public int findComplement(int num) {
        //find the number that has the same length as num but all are 1
        long num0 = 1;
        while(num >= num0)
            num0 <<= 1;
        num0 -= 1;
        return (int)(num ^ num0);
    }
}
// @lc code=end

