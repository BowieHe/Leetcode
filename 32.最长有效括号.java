import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        // push random start number, which also means the minimun value that haven't
        // benn matched
        stack.push(-1);
        char[] a = s.toCharArray();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char b = a[i];
            if (b == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }

        return res;
    }
}
// @lc code=end
