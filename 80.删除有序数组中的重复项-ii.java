import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> appearance = new HashMap<>();
        int slow = 0, fast = 1;
        appearance.put(nums[0], 1);
        while(fast < nums.length) {
            int count = appearance.getOrDefault(nums[fast], 0);
            if(count < 2) {
                appearance.put(nums[fast],count + 1);
                slow++;
                nums[slow] = nums[fast];    
            }
            fast++;
        } 
        return slow + 1;
    }
}
// @lc code=end

