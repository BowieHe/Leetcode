import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int dup = 0, offset = 0;
        int curNum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > curNum) {
                dup = 0;
                curNum = nums[i];
            }
            dup++;
            if (dup > 2) {
                offset++;
            }

            if (offset > 0) {
                nums[i - offset] = nums[i];
            }
        }

        return nums.length - offset;

    }
}
// @lc code=end