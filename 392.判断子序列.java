/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0)return true;
        char[] ct = t.toCharArray();
        int index = 0;
        for(char c: ct){
            if(s.charAt(index) == c)
                index++;
            if(index == s.length())
                return true;
        }
        return false;
    }
}
// @lc code=end

