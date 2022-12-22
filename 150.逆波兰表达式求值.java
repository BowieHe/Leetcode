import java.util.Stack;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String t: tokens) {
            if("+-*/".contains(t)) {
                int a = stk.pop(), b = stk.pop();
                switch(t) {
                    case "+":
                        stk.push(a + b);
                        break;
                    case "*":
                        stk.push(a * b);
                        break;
                    case "/":
                        stk.push(b / a);
                        break;
                    case "-":
                        stk.push(b - a);
                        break;
                }
            } else {
                stk.push(Integer.parseInt(t));
            }
        }
        return stk.pop();
    }
    
}
// @lc code=end

