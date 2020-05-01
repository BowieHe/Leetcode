import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int left = 0, right = c.length - 1;
        while(left < right){
            if(isVowel(c[left]) || isVowel(c[right])){
                if(!isVowel(c[right])){
                    right--;
                    continue;
                }
                else if(!isVowel(c[left])){
                    left++;
                    continue;
                }
                else{
                    char temp = c[left];
                    c[left] = c[right];
                    c[right] = temp;
                    left++;
                    right--;
                    continue;
                }
            }
            left++;
            right--;
        }
        return new String(c);
    }
    public boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' 
            ||c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }
}
// @lc code=end

