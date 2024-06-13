/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int ans = nums.length;
        
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
            System.out.println(ans);
        }
        return ans;
    }
}
// @lc code=end

