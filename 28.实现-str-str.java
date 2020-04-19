/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length(), len2 = needle.length(); 
        if(len1 < len2)return -1;
        for(int i=0; i<(len1-len2+1); i++){
            if(haystack.substring(i, i+len2).equals(needle))return i;
        }
        return -1;
    }
}
// @lc code=end

