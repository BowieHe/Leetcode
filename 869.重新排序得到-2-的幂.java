import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=869 lang=java
 *
 * [869] 重新排序得到 2 的幂
 */

// @lc code=start
class Solution {

    boolean[] vis;

    public boolean reorderedPowerOf2(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        return backTrace(nums, 0, 0);
    }

    public boolean backTrace(char[] nums, int index, Integer cur) {
        if(index == nums.length) {
            return canDevidedBy2(cur);
        }

        for(int i = 0; i < nums.length; i++) {
            if((vis[i] || (cur == 0 && nums[i] == '0') ||(i > 0 && !vis[i - 1] &&  nums[i] == nums[i - 1]))) {
                continue;
            }

            vis[i] = true;
            if(backTrace(nums, index + 1, (cur * 10 + (nums[i] - '0')))) {
                return true;
            }
            vis[i] = false;

        }
        return false;

    }

    boolean canDevidedBy2(int num) {
        return ((num & (num - 1)) == 0);
    }
}
// @lc code=end

