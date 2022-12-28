import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        int[] dp = new int[s.length() + 1];
        int maxVal = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stk.push(i);
                dp[i + 1] = 0;
            } else {
                if(stk.isEmpty()) {
                    dp[i + 1] = 0;
                } else {
                    // right brackle matched
                    int leftIndex = stk.pop();
                    int val = 1 + (i - leftIndex) + dp[leftIndex];
                    maxVal = Math.max(maxVal, val);
                    dp[i + 1] = val;
                }
            }
        }
        return maxVal;
        
    }
}
// @lc code=end

