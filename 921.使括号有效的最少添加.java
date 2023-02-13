import java.util.Stack;

/*
 * @lc app=leetcode.cn id=921 lang=java
 *
 * [921] 使括号有效的最少添加
 */

// @lc code=start
class Solution {
    public int minAddToMakeValid(String s) {
        int need = 0, res = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                need++;
            } else if(s.charAt(i) == ')') {
                need--;
                if(need == -1) {
                    need = 0;
                    res++;
                }
            }
        }
        return res + need;
        
    }
}
// @lc code=end

