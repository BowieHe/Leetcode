import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {

        if(nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int index = 0;
        int res = Integer.MAX_VALUE;
        while(index < nums.length - 2) {
            int left = index + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[index] + nums[left] + nums[right];
                 if(target == sum) {
                    return sum;
                 } else if(Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                } 
                if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            index++;
        }
        return res;
    }
}
// @lc code=end

