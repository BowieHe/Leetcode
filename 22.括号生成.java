import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if(n == 0) {
            return res;
        }

        backtrace(n, n, new StringBuilder());
        return res;
    }

    void backtrace(int left, int right, StringBuilder sb) {
        if(right < left) return ;
        if(left < 0 || right < 0) return;
        if(left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }

        sb.append("(");
        backtrace(left - 1, right, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(")");
        backtrace(left, right - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
// @lc code=end

