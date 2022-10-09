/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        int res = 0;
        for(int num: nums) {
            int i = 0, j = res;
            while(i < j) {
                int mid = i + ((j - i) / 2);
                if(tail[mid] >= num) {
                    j = mid;
                } else if(tail[mid] < num) {
                    i = mid + 1;
                } 
            }
            tail[i] = num;
            if(j == res) {
                res++;
            }
            System.out.println(res);
        }
        return res;
    }
}
// @lc code=end

