import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for(char a: s1.toCharArray()) need.put(a, need.getOrDefault(a, 0) + 1);
        int valid = 0;
        if(s1.length() > s2.length()) return false;
        while(right < s2.length()) {
            char cur = s2.charAt(right);
            right++;
            if(need.containsKey(cur)) {
                int needCount = window.getOrDefault(cur, 0);
                window.put(cur, needCount + 1);
                if(needCount + 1 == need.get(cur)) {
                    valid++;
                }
                
            }
            while(right - left >= s1.length()) {
                System.out.print(valid);

                System.out.print("===");
                System.out.println(left);
                if(valid == need.keySet().size()) return true;
                char rm = s2.charAt(left);
                left++;
                if(window.containsKey(rm)) {
                    int val = window.get(rm);
                    if(val == 1) {
                        window.remove(rm);
                    } else {
                        window.put(rm, val - 1);
                    }
                    if(val == need.get(rm)) {
                        valid--;
                    }
                    
                }
            }
        }
        return false;
    }
}
// @lc code=end

