import java.util.Arrays;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 缺失数字
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums)
            set.add(num);
        int len = nums.length + 1;
        for(int cur = 0; cur < len; cur++){
            if(!set.contains(cur))
                return cur;
        }
        return -1;
    }
}
// @lc code=end

