import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int change = 0;
        for(int cur = 0; cur < nums.length; cur++){
            if(nums[cur] != 0){
                nums[change] = nums[cur];
                change ++;
            }
        }
        for(int i = nums.length - 1; i >= change; i--){
            nums[i] = 0;
        }
    }
}
// @lc code=end

