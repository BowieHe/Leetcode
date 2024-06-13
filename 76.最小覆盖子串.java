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
        String res = "";
        int indexL = -1, indexR = s.length();
        int lens = s.length(), lent = t.length();
        if (lent > lens) {
            return res;
        }

        HashMap<Character, Integer> need = new HashMap<>();

        for (int i = 0; i < lent; i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (int i = 0; i < lent; i++) {
            if (need.keySet().contains(s.charAt(i))) {
                need.put(s.charAt(i), need.getOrDefault(s.charAt(i), 0) - 1);
            }
        }

        if (containsAll(need)) {
            return s.substring(0, t.length());
        }

        int left = 0;
        for (int i = lent; i < lens; i++) {
            char rChar = s.charAt(i);
            if (!need.keySet().contains(rChar)) {
                continue;
            }

            need.put(rChar, need.getOrDefault(rChar, 0) - 1);

            if (containsAll(need)) {
                while (left <= i) {
                    if (!need.keySet().contains(s.charAt(left))) {
                        left++;
                        continue;
                    }
                    if ((i - left) < (indexR - indexL)) {
                        indexR = i;
                        indexL = left;
                        res = s.substring(indexL, indexR + 1);
                    }
                    need.put(s.charAt(left), need.getOrDefault(s.charAt(left), 0) + 1);
                    left++;
                    if (!containsAll(need)) {
                        break;
                    }
                }

            }
            // while (left < i) {

            // if (!need.keySet().contains(s.charAt(left))) {
            // left++;
            // continue;
            // }

            // if (!containsAll(need)) {
            // break;
            // }

            // if ((i - left) <= (indexR - indexL)) {
            // indexR = i;
            // indexL = left;
            // res = s.substring(indexL, indexR + 1);
            // }
            // need.put(s.charAt(left), need.getOrDefault(s.charAt(left), 0) + 1);
            // left++;
            // }
        }

        return res;
    }

    public boolean containsAll(HashMap<Character, Integer> need) {
        for (Map.Entry<Character, Integer> e : need.entrySet()) {
            if (e.getValue() > 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
