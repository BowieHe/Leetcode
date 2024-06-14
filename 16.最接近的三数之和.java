import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        int minG = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    left += 1;
                } else if (sum == target) {
                    return target;
                } else {
                    right -= 1;
                }
                int abv = Math.abs(sum - target);
                if (abv < minG) {
                    minG = abv;
                    res = sum;
                }

            }
        }

        return res;
    }
}
// @lc code=end
