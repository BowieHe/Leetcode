import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for(char c: t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        Integer left = 0, right = 0, valid = 0;
        Integer start = 0, len = Integer.MAX_VALUE;
        while(right < s.length()) {
            char cur = s.charAt(right);
            right++;
            if(need.containsKey(cur)) {
                windows.put(cur, windows.getOrDefault(cur, 0) + 1);
                if(windows.get(cur).equals(need.get(cur))) {
                    valid++;
                }
            }
            while(valid.equals(need.keySet().size())) {
                if(right - left < len) {
                    start = left;
                    len = right - left;
                    System.out.println(String.format("%d == %d", start, len));
                    System.out.println(s.substring(start, start + len));
                }
                char rm = s.charAt(left);
                left++;
                if(need.containsKey(rm)) {
                    if(windows.get(rm).equals(need.get(rm))) {
                        valid--;
                    }
                    windows.put(rm, windows.get(rm) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE? "": s.substring(start, start + len);
    }
}
// @lc code=end

