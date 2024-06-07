/*
 * @lc app=leetcode.cn id=410 lang=java
 *
 * [410] 分割数组的最大值
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        for (int n : nums) {
            right += n;
            left = Math.max(left, n);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int t = f(mid, nums);
            if (t > k) {
                left = mid + 1;
            } else {
                right = mid;
            }
            System.out.println("left:" + left + " right:" + right);
        }
        return left;
    }

    int f(int sum, int[] nums) {
        int t = 0;
        int temp = 0;
        for (int n : nums) {
            temp += n;
            if (temp >= sum) {
                t++;
                if (temp > sum) {
                    temp = n;
                } else if (temp == sum) {
                    temp = 0;
                }
            }
        }
        if (temp > 0) {
            // put the rest into one array
            t++;
        }
        System.out.println("get t:" + t + " for sum:" + sum);
        return t;
    }
}
// @lc code=end
