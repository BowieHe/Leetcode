import java.util.Map;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] s = str.split(" ");
        char[] c = pattern.toCharArray();
        if(c.length != s.length) 
            return false;
        for(int i = 0; i < c.length; i++){
            if(map.get(c[i]) == null)
                map.put(c[i], s[i]);
            else if(!map.get(c[i]).equals(s[i]))
                return false;
        }
        Set<String> set = new HashSet<>();
        for(String st: map.values()){
            if(set.contains(st))
                return false;
            else
                set.add(st);
        }
        return true;
    }
}
// @lc code=end

