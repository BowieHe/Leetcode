/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] count = new int[26];
        int len = 0;
        while(len < s.length()){
            count[s.charAt(len) - 'a']++;
            count[t.charAt(len) - 'a']--;
            len++;
        }
        for(int i: count){
            if(i != 0)
                return false;
        }
        return true;
    }
}
// @lc code=end

