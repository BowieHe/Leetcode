import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=389 lang=java
 *
 * [389] 找不同
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        char ans = 0;
        for(int i = 0; i < s.length(); i++){
            ans ^= cs[i] ^ ct[i];
        }
        ans ^= ct[t.length() - 1];
        return ans;
    }
}
// @lc code=end

