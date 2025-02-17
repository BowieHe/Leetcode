/*
 * @lc app=leetcode.cn id=1456 lang=java
 *
 * [1456] 定长子串中元音的最大数目
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxVowels(String s, int k) {
        // char[] charSet = s.toCharArray();
        // int len = charSet.length;

        // Set<Character> alpha = Set.of('a', 'e', 'i', 'o', 'u');
        // boolean[] isValid = new boolean[len];

        // int count = 0;
        // int max = 0;
        // for (int i = 0; i < len; i++) {

        // isValid[i] = alpha.contains(charSet[i]);
        // if (i < k) {
        // if (isValid[i])
        // count++;

        // } else {
        // if (isValid[i])
        // count++;
        // if (isValid[i - k])
        // count--;
        // }
        // if (count == k) {
        // return k;
        // }
        // max = Math.max(max, count);

        // }

        // return max;

        int count = 0;
        int max = 0;

        char[] chs = s.toCharArray();

        for (int i = 0; i < k; i++) {
            if (isValid(chs[i])) {
                count++;
            }

        }
        if (count == k) {
            return k;
        }
        max = count;

        for (int i = k; i < chs.length; i++) {
            int validCurrent = isValid(chs[i]) ? 1 : 0;
            int validPast = isValid(chs[i - k]) ? 1 : 0;
            count += (validCurrent - validPast);
            max = Math.max(max, count);

        }
        return max;

    }

    private boolean isValid(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
// @lc code=end
