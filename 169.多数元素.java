import java.util.HashSet;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int m : nums){
            map.put(m, map.getOrDefault(m, 0) + 1);
            if(map.get(m) > (len >>> 1)){
                return m;
            }
        }
        return -1;
    }
}
// @lc code=end

