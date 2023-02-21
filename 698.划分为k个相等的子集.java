import java.util.Arrays;
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
        int sum = 0;
        for(int n: nums) {
            sum += n;
        }
        if(sum % k > 0) {
            return false;
        }
        sum = sum / k;
        int used = 0;
        int[] bucket = new int[k + 1];
        Arrays.sort(nums);
        return backtrace(k, nums, sum, 0, used, bucket);
    }

    Map<Integer, Boolean> memo = new HashMap<Integer, Boolean>();
    boolean backtrace(int k, int[] nums, int target, int start, int used, int[] bucket) {
        if(k == 0) {
            return true;
        }

        if(bucket[k] == target) {
            boolean res = backtrace(k - 1, nums, target, 0, used, bucket);
            memo.put(used, res);
            return res;
        }

        if(memo.containsKey(used)) {
            return memo.get(used);
        }

        for(int i = start; i < nums.length; i++) {
            if(((used >> i) & 1) == 1) {
                continue;
            }
            if((bucket[k] + nums[i]) > target) {
                while(i + 1 < nums.length && nums[i + 1] == nums[i]) {
                    i++;
                }
                continue;
            }

            used |= (1 << i);
            bucket[k] += nums[i];
            if(backtrace(k, nums, target, i, used, bucket)) {
                return true;
            }

            used ^= (1 << i);
            bucket[k] -= nums[i];
        }

        return false;
    }
}
// @lc code=end

