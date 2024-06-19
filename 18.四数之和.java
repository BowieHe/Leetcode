import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i < n - 2; i++) {
            // if (i > 1 && nums[i] == nums[i - 1]) {
            // continue;
            // }
            // System.out.println("process i:" + i + " and value:" + nums[i]);
            for (int j = i + 1; j < n - 1; j++) {
                // if (i > 1 && nums[i] == nums[i - 1] && j > (i + 1) && nums[j] == nums[j - 1])
                // {
                // continue;
                // }
                // System.out.println("process j:" + j + " and value:" + nums[j]);
                int left = 0, right = n - 1;
                while (left < i && right > j) {
                    if (left > 0 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    } else if (right < n - 1 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }
                    long sum = (long) nums[left] + nums[i] + nums[j] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        List<Integer> r = Arrays.asList(nums[left], nums[i], nums[j], nums[right]);
                        if (!res.contains(r)) {
                            res.add(r);
                        }

                        right--;
                        left++;
                    }
                }
            }
        }

        return res;

    }

}
// @lc code=end
