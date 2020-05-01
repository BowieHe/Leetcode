/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int i = 1; i < s.length(); i++){
            if(s.length() % i == 0){
                if(judge(s.substring(0, i), s))return true;
            }
        }
        return false;
    }
    public boolean judge(String sub, String s){
        int len = sub.length();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(i % len))
                return false;
        }
        return true;
    }
}
// @lc code=end

