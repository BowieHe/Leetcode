/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        double ans = (Math.log10(n) / Math.log10(3));
        if(ans % 1 == 0)return true;
        return false;
    }
}
// @lc code=end

