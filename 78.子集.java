import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        // res.add(new LinkedList<>());
        if(nums.length == 0) {
            return res;
        }

        backtrace(0, nums, new LinkedList<Integer>());
        return res;
    }



    void backtrace(int start, int[] nums, LinkedList<Integer> cur) {

        res.add(new LinkedList<>(cur));
        for(int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
  
            backtrace(i + 1, nums, cur);

            cur.removeLast();

        }
    }
}
// @lc code=end

