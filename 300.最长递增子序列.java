import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        //int[] tail = new int[nums.length];
        //int res = 0;
        //for(int num: nums) {
            //int i = 0, j = res;
            //while(i < j) {
                //int mid = i + ((j - i) / 2);
                //if(tail[mid] >= num) {
                    //j = mid;
                //} else if(tail[mid] < num) {
                    //i = mid + 1;
                //} 
            //}
            //tail[i] = num;
            //if(j == res) {
                //res++;
            //}
            //System.out.println(res);
        //}
        //return res;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
// @lc code=end

