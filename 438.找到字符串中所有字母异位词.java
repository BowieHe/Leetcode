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
      Map<Character, Integer> window = new HashMap<>();
      Map<Character, Integer> need = new HashMap<>();

      if(s.length() < p.length()) {
        return new ArrayList<>();
      }

      List<Integer> res = new ArrayList<>();
      int[] sCount = new int[26];
      int[] pCount = new int[26];
      for(int i = 0; i < p.length(); i++) {
        ++sCount[s.charAt(i) - 'a'];
        ++pCount[p.charAt(i) - 'a'];
      }

      if(Arrays.equals(sCount, pCount)) {
        res.add(0);
      }

      for(int i = 0; i < s.length() - p.length(); i++) {
        ++sCount[s.charAt(i + p.length()) - 'a'];
        --sCount[s.charAt(i) - 'a'];
        if(Arrays.equals(sCount, pCount)) {
            res.add(i + 1);
        }
      }
      return res;
    }
    
}
// @lc code=end

