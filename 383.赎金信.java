/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length())
            return false;
        int[] count = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            count[magazine.charAt(i)  - 'a']++;
            if(i < ransomNote.length())
                count[ransomNote.charAt(i)  - 'a']--;
        }
        for(int n: count)
            if(n < 0) return false;
        return true;
    }
}
// @lc code=end

