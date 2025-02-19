/*
 * @lc app=leetcode.cn id=2156 lang=java
 *
 * [2156] 查找给定哈希值的子串
 */

// @lc code=start
class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        char[] chs = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            int cur = chs[i] - 'a';
            sum += cur * Math.pow(power, i);
        }

        for (int i = k; i < chs.length; i++) {
            if (sum % modulo == hashValue) {
                return s.substring(i - k, i - 1);
            }

            sum -= chs[i - k] - 'a';
            sum /= power;
            sum += (chs[i] - 'a') * Math.pow(power, k - 1);

        }

        return "";
    }
}
// @lc code=end
