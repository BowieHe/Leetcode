/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        if(n < m)return addBinary(b, a);

        int carry = 0, j = m - 1;
        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i > -1; i--){
            if(a.charAt(i) == '1')carry++;
            if(j > -1 && b.charAt(j--) == '1')carry++;
            
            if(carry % 2 == 1)sb.append('1');
            else sb.append('0');
            carry /= 2;
        }
        if(carry == 1)sb.append('1');
        return sb.reverse().toString();
    }
}
// @lc code=end

