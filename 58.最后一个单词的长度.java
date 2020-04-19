/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length() - 1;
        while(len >= 0 && s.charAt(len) == ' ')len--;
        if(len < 0)return 0;
        int count = 0;
        while(len >= 0 && s.charAt(len) != ' '){
            len--;
            count++;
        }
        return count;
        /*int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = 0;
        while(end >= 0 && s.charAt(end) != ' ') {
            end--;
            start++;
        }
        return start;*/
    }
}
// @lc code=end

