import java.util.Stack;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            
            if (t.equals("+") ||t.equals("-") || t.equals("*") || t.equals("/")) {
                int v1 = stack.pop();
                int v2 = stack.pop();

                if (t.equals("+")) {
                    stack.push(v1 + v2);
                } else if (t.equals("-")) {
                    stack.push(v2 - v1);
                } else if (t.equals("*")) {
                    stack.push(v1 * v2);
                } else {
                    stack.push(v2 / v1);
                }
            } else {
                stack.push(Integer.valueOf(t));
            }
        }
        return stack.pop();
    }

}
// @lc code=end
