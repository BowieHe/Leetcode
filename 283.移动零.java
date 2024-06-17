import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else {
                nums[i - zero] = nums[i];
            }
        }

        for (int j = nums.length - zero; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
// @lc code=end
