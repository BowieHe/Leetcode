/*
 * @lc app=leetcode.cn id=342 lang=java
 *
 * [342] 4的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfFour(int num) {
        return ((Math.log10(num) / Math.log10(4)) % 1 == 0);
    }
}
// @lc code=end

