import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1541 lang=java
 *
 * [1541] 平衡括号字符串的最少插入次数
 */

// @lc code=start
class Solution {
    public int minInsertions(String s) {
        int res = 0, need = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                need += 2;
                // res++;
                if (need % 2 == 1) {
                    need--;
                    res++;
                }
            } else {
                need--;
                if (need == -1) {
                    res++;
                    need = 1;
                }
            }
        }
        return res + need;
    }
}
// @lc code=end
