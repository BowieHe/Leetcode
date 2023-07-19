/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> temp = new HashMap<>();
        for(String str: strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);

            String key = String.valueOf(s);
            // System.out.println(key);
            List<String> cur = temp.getOrDefault(key, new ArrayList<>());
            cur.add(str);
            temp.put(key, cur);
        }

        return new ArrayList(temp.values());
    }
}
// @lc code=end

