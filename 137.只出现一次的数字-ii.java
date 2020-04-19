/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for(int num: nums){
            
            twos |= ones & num;
            ones ^= num;
            
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}
// @lc code=end

