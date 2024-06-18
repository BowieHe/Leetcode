/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                sb.append(' ');
            }
        }
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        String newStr = sb.toString();
        String[] strs = newStr.split(" ");
        StringBuilder nsb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            nsb.append(strs[i]);
            nsb.append(" ");
        }

        nsb.deleteCharAt(nsb.length() - 1);
        return nsb.toString();
    }

}
// @lc code=end
