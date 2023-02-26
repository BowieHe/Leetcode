import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if(n == 0 || k == 0) {
            return res;
        }
        backtrace(1, n, k, new LinkedList<Integer>());
        return res;
    }

    void backtrace(int start, int n, int k, LinkedList<Integer> nums) {
        if(nums.size() == k) {
            res.add(new LinkedList<>(nums));
            return;
        }

        for(int i = start; i <= n; i++) {
            nums.addLast(i);
            backtrace(i + 1, n, k, nums);
            nums.removeLast();
        }
    }
}
// @lc code=end

