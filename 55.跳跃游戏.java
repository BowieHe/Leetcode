/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public boolean canJump(int[] nums) {

        int max = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= len - 1) {
                    return true;
                }
            }
        }

        return false;
    }

}
// @lc code=end
