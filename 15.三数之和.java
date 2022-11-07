import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) {
            return res; 
        }
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = n - 1;
            while(left < right) {
                // System.out.println(i + "" + left + "" + right);
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < 0) {
                    left++;
                } else if(sum > 0) {
                    right--;
                } else {

                System.out.println(i + "" + left + "" + right);
                    List<Integer> cur = new ArrayList<Integer>();
                    cur.add(nums[i]);
                    cur.add(nums[left]);
                    cur.add(nums[right]);
                    res.add(cur);
                    // left++;
                    // right--;
                    while(left + 1 < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while(right - 1 > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }

        }
        return res;
    }
}
// @lc code=end

