/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int len = numbers.length;
        for(int i = 0; i < len; i++){
            for(int j = i + 1;j < len; j++){
                if(numbers[i] + numbers[j] == target){
                    ans = new int[]{i + 1 ,j + 1};
                    return ans;
                }else if(numbers[i] + numbers[j] > target)
                    break;
            }
        }
        return ans;
    }
}
// @lc code=end

