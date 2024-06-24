/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i + 1] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
// @lc code=end
