/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int ans = 0;
        while(x != 0){
            int pop = x % 10;
            if((ans) > Integer.MAX_VALUE/10 || (ans*10) == Integer.MAX_VALUE && pop > 7){
                return 0;
            }// 7的补码为-8
            if((ans) < Integer.MIN_VALUE/10 || (ans*10) == Integer.MIN_VALUE && pop < -8){
                return 0;
            }
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}
// @lc code=end

