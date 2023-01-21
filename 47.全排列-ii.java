import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backTrace(res, nums, perm, 0);
        return res;
    }

    void backTrace(List<List<Integer>> res, int[] nums, List<Integer> perm, int index) {
        if(index == nums.length) {
            res.add(new ArrayList<>(perm));
        }
        for(int i = 0; i < nums.length; i++) {
            if(vis[i] || (i > 0 && nums[i - 1] == nums[i] && !vis[i - 1])) {
                continue;
            }
            vis[i] = true;
            perm.add(nums[i]);
            backTrace(res, nums, perm, index + 1);
            vis[i] = false;
            perm.remove(index);
        }
    }
}
// @lc code=end

