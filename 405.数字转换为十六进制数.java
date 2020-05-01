/*
 * @lc app=leetcode.cn id=405 lang=java
 *
 * [405] 数字转换为十六进制数
 */

// @lc code=start
class Solution {
    public String toHex(int num) {
        char[] hex = "0123456789abcdef".toCharArray();
        String s = new String();
        while(num != 0){
            int end = num & 15;
            s = hex[end] + s;
            num >>>= 4;
        }
        if(s.length() == 0){
            s += "0";
        }
        return s;
    }
}
// @lc code=end

