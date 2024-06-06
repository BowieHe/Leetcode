/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int pos = nums.length - 1;
        int step = 0;
        while (pos > 0) {
            for (int i = 0; i < pos; i++) {
                if (nums[i] + i >= pos) {
                    step++;
                    pos = i;
                    break;
                }
            }
        }

        return step;
    }

}
// @lc code=end
