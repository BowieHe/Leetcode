/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel表列序号
 */

// @lc code=start
class Solution {
    public int titleToNumber(String s) {
        char[] c = s.toCharArray();
        int ans = 0;
        for(char cha: c){
            int number = (int)(cha - 'A' + 1);
            ans *= 26;
            ans += number; 
        }
        return ans;
    }
}
// @lc code=end

