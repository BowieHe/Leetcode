/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int length = 0;
        int end = 0;
        int maxPos = 0;
        int step = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if(i == end) {
                step++;
                end = maxPos;
            }
        }
        return step;
    }
}
// @lc code=end

