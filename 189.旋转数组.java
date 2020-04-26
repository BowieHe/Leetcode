/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        /*k = k % 26;
        int count = 0;
        for(int start = 0; count < nums.length; start++){
            int current = start;
            int prev = nums[start];
            do{
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            }while(start != current);
        }*/
        k %= nums.length;
        int count = 0;
        for(int start = 0; count < nums.length; start++){
            int current = start;
            int prev = nums[start];
            do{
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                current = next;
                prev = temp;
                count++;
            }while(start != current);
        }
    }
}
// @lc code=end

