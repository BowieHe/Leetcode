import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1541 lang=java
 *
 * [1541] 平衡括号字符串的最少插入次数
 */

// @lc code=start
class Solution {
    public int minInsertions(String s) {
        int need = 0, res = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                need+= 2;
                if(need % 2 == 1) {
                    res++;
                    need--;
                }
            }
            if(s.charAt(i) == ')') {
                need--;
                if(need == -1) {
                    res++;
                    need = 1;
                }
            }
        }
        return res + need;
    }
}
// @lc code=end

