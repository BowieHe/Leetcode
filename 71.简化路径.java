import java.util.Arrays;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for (String p : paths) {
            if (p.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (p.equals(".") || p.length() == 0) {
                continue;
            } else {
                stack.push(p);
            }
        }

        String r = "";
        while (!stack.empty()) {
            r = "/" + stack.pop() + r;
        }

        return r.length() > 0 ? r : "/";
    }
}
// @lc code=end
