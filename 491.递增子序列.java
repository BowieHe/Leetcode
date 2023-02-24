import java.util.HashSet;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length != 0) {
            backtrace(nums, 0);
        }

        return res;
    }

    void backtrace(int[] nums, int start) {
        if(track.size() >= 2) {
            res.add(new LinkedList<>(track));
        }

        HashSet<Integer> used = new HashSet<>();
        for(int i = start; i < nums.length; i++) {
            if(!track.isEmpty() && track.getLast() > nums[i]) {
                continue;
            }

            if(used.contains(nums[i])) {
                continue;
            }

            used.add(nums[i]);
            track.add(nums[i]);
            backtrace(nums, i + 1);
            track.removeLast();
        }
    }
}
// @lc code=end

