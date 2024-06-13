import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }

        int left = 0, right = 0, res = 0;
        HashMap<Character, Integer> h = new HashMap<>();
        while(right < s.length()) {
            Character c = s.charAt(right);
            if(h.containsKey(c) ) {
                left = Math.max(left, h.get(c) + 1);
            }
            res = Math.max(res, right - left + 1);
            h.put(c, right);
            right++;
        }

        return res;
    }
}
// @lc code=end

