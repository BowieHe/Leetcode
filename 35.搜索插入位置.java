/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = (left + right) / 2;
        while(left <= right){
            mid = (left + right) / 2;
            if(target == nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}
// @lc code=end

