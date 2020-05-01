/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 2)
            return true;
        long left = 2, right = num / 2, mid, guess;
        while(left <= right){
            mid = left + (right - left) / 2;
            guess = mid * mid;
            if(guess > num){
                right = mid - 1;
            }
            else if(guess < num){
                left = mid + 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

