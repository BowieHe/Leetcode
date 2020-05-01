/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
class Solution {
    public boolean isUgly(int num) {
        if(num == 0)return false;
        if(num == 1)return true;

        int[] list = new int[]{2,3,5};
        for(int i = 0; i < 3 ;){
            if(num == 1 && i == 2)
                break;
            if(num % list[i] == 0){
                num /= list[i];
                continue;
            }   
            else{
                i++;
                if(i == 3)return false;
            }
        }
        return true;
    }
}
// @lc code=end

