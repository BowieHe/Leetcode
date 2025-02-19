/*
 * @lc app=leetcode.cn id=2958 lang=java
 *
 * [2958] 最多 K 个重复元素的最长子数组
 */

// @lc code=start

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        Map<Integer, Integer> visited = new HashMap();
        int left = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            visited.merge(nums[i], 1, Integer::sum);
            while (visited.get(nums[i]) > k) {
                visited.merge(nums[left], -1, Integer::sum);
                left++;
            }

            res = Math.max(res, i - left + 1);
        }

        return res;
    }
}
// @lc code=end
