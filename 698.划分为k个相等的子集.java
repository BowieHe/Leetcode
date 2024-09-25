import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=698 lang=java
 *
 * [698] 划分为k个相等的子集
 */

// @lc code=start
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (nums.length < k || sum % k != 0)
            return false;
        int target = sum / k;
        Integer[] array = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(array, Collections.reverseOrder());

        return backtrace(array, 0, new int[k], k, target);
    }

    public boolean backtrace(Integer[] nums, int index, int[] bucket, int k, int target) {

        if (index == nums.length)
            return true;
        for (int i = 0; i < k; i++) {
            if (i > 0 && bucket[i] == bucket[i - 1])
                continue;
            if (bucket[i] + nums[index] > target)
                continue;

            bucket[i] += nums[index];

            if (backtrace(nums, index + 1, bucket, k, target))
                return true;

            bucket[i] -= nums[index];
        }
        return false;
    }
}
// @lc code=end
