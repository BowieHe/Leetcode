import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        /*HashMap<Integer, Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int i: nums){
            if(map.get(i) == 1)return i;
        }
        return 0;*/
        int ans = 0;
        for(int i: nums){
            ans ^= i;
        }
        return ans;
    }
}
// @lc code=end

