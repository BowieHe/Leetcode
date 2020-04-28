import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        return makeMap(s, t) && makeMap(t, s);
    }
    public boolean makeMap(String s, String t){
        int[] map = new int[128];
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(map[chs[i]] == 0){
                map[chs[i]] = cht[i];
            }else if(map[chs[i]] != cht[i])
                return false;
        }
        return true;
    }
}
// @lc code=end

