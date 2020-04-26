/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^0-9a-z]","");
        char[] c = s.toCharArray();
        int i = 0, j = c.length - 1;
        while(i < j){
            if(c[i] != c[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
// @lc code=end

