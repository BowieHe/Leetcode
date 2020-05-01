/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1, len2 = num2.length() - 1, carry = 0;
        StringBuilder ans = new StringBuilder("");
        while(0 <= len1 || 0 <= len2){
            int n1 = len1 >= 0? (num1.charAt(len1) - '0'): 0;
            int n2 = len2 >= 0? (num2.charAt(len2) - '0'): 0;
            int temp = n1 + n2 + carry;
            carry = temp / 10;
            ans.append(temp % 10);
            len1--;
            len2--;
        }
        if(carry == 1)ans.append(1);
        return ans.reverse().toString();
    }
}
// @lc code=end

