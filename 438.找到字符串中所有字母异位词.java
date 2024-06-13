import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    int sLen = s.length(), pLen = p.length();

    if (sLen < pLen) {
      return res;
    }

    int[] count = new int[26];
    for (int i = 0; i < p.length(); i++) {
      count[s.charAt(i) - 'a']++;
      count[p.charAt(i) - 'a']--;
    }

    int dif = 0;
    for (int i = 0; i < 26; i++) {
      if (count[i] != 0) {
        dif++;
      }
    }

    if (dif == 0) {
      res.add(0);
    }

    int left = 0;
    while (left + pLen < sLen) {
      // delete the left one
      if (count[s.charAt(left) - 'a'] == 1) { // old one is different, return to 0
        dif--;
      } else if (count[s.charAt(left) - 'a'] == 0) {// old one is included, add
        dif++;
      }
      count[s.charAt(left) - 'a']--;

      // add the right one, new one
      if (count[s.charAt(left + pLen) - 'a'] == -1) {// the new added in empty, add one
        dif--;
      } else if (count[s.charAt(left + pLen) - 'a'] == 0) {// the new added has been matched,
        dif++;
      }
      count[s.charAt(left + pLen) - 'a']++; // add the new one

      if (dif == 0) {
        res.add(left + 1);
      }

      left++;
    }

    return res;
  }
}
// @lc code=end
