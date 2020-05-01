/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 */

// @lc code=start
class Solution {
    public int addDigits(int num) {
        if(num < 10)return num;
        int ans = 0;
        do{
            while(num > 0){
                ans += num % 10;
                num /= 10;
            }
            num = ans;
            ans = 0;
        }while(num > 9);
        return num;
    }
}
// @lc code=end

