import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();
        int left = 0, right = 0;
        int res = 0;
        while(right < s.length()) {
            char c = s.charAt(right);
            if(window.containsKey(c)) {
                left = Math.max(left, window.get(c) + 1);
            }
            res = Math.max(res, right - left + 1);
            window.put(c, right);
            right++;
        }
        return res;
    }
}
// @lc code=end

