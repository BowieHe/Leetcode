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
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        int count[] = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']--;
            count[s2.charAt(i) - 'a']++;
        }

        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                diff++;
            }
        }

        if (diff == 0) {
            return true;
        }
        for (int i = 0; i < len2 - len1; i++) {
            if (count[s2.charAt(i) - 'a'] == 1) {
                diff--;
            } else if (count[s2.charAt(i) - 'a'] == 0) {
                diff++;
            }
            count[s2.charAt(i) - 'a']--;

            if (count[s2.charAt(i + len1) - 'a'] == -1) {
                diff--;
            } else if (count[s2.charAt(i + len1) - 'a'] == 0) {
                diff++;
            }
            count[s2.charAt(i + len1) - 'a']++;

            if (diff == 0) {
                return true;
            }

        }

        return false;
    }
}
// @lc code=end
