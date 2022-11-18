/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        s = s.stripLeading();
        s = s.stripTrailing();
        String[] subS = s.split(" ");
        for(String su: subS) {
            System.out.print(su);
            System.out.println(su.length());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = subS.length - 1; i >= 0; i--) {
            String sub = subS[i];
            if(sub.length() == 0) {
                continue;
            }
            // String reSub = reverse(sub);
            sb.append(sub);
            if(i > 0) {
                sb.append(" ");
            }
        } 
        return sb.toString();
    }

}
// @lc code=end

