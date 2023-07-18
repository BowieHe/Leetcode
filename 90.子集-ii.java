/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    List<Integer> t = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        dfs(false, 0, nums);

        return res;
    }

    public void dfs(Boolean choosePre, int index, int[] nums) {
        if(index == nums.length) {
            res.add(new ArrayList<>(t));
            return;
        }
        
        dfs(false, index + 1, nums);
        if(!choosePre && index > 0 && nums[index] == nums[index - 1]) {
            return;
        }
        t.add(nums[index]);
        dfs(true, index + 1, nums);
        t.remove(t.size() - 1);

    }
}
// @lc code=end

