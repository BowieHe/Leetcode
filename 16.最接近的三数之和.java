import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int minGap = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            int j = i - 1, k = i + 1;
            while (j >= 0 & k < nums.length) {
                int sum = nums[i] + nums[j] + nums[k];
                int gap = (sum - target);
                if (Math.abs(gap) < Math.abs(minGap)) {
                    res = sum;
                    minGap = gap;
                    System.out.println("left:" + j + " mid:" + i + " right:" + k + " res:" + res);
                }

                if (gap == 0) {
                    return sum;
                } else if (gap < 0) {
                    k++;
                } else {
                    j--;
                }
            }
        }

        return res;
    }
}
// @lc code=end
