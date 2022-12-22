import java.util.Stack;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stk = new Stack<>();
        int i = 1;
        for(String part: parts) {
            System.out.print(i++);
            System.out.println(part);
            if(part.equals("") || part.equals(".")) {
                continue;
            } else if(part.equals("..")) {
                if(!stk.empty()) {
                    stk.pop();
                
                }
                continue;
            }
            stk.push(part);
        }
        String res = "";
        while(!stk.isEmpty()) {
            res = ("/" + stk.pop() + res);
        }
        return res.equals("")? "/" : res;
    }
}
// @lc code=end

