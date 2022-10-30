/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = Integer.MIN_VALUE;
        while(left < right) {
            int current = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, current);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
// @lc code=end

