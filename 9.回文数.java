/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        /* use digit to solve problem
        if(x < 0 || (x % 10 == 0 && x != 0))return false;
        int reverse = 0;
        while(x > reverse){
            reverse = reverse * 10 + (x % 10);
            x /= 10;
        }
        return (reverse == x || (reverse / 10) == x);*/
        //StringBuilder is different from String
        String reverse = (new StringBuilder(x+"").reverse().toString());
        return (x+"").equals(reverse);
    } 
}
// @lc code=end

