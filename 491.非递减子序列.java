/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 非递减子序列
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length < 2) {
            return res;
        }
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int index) {
        if (track.size() >= 2) {
            res.add(new LinkedList<>(track));
        }

        HashSet<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!track.isEmpty() && track.getLast() > nums[i]) {
                continue;
            }
            if (used.contains(nums[i])) {
                continue;
            }

            used.add(nums[i]);
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}
// @lc code=end
