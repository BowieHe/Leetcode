/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
class Solution {
    public boolean isUgly(int n) {

        if (n == 0)
            return false;
        int[] ugly = new int[] { 5, 3, 2 };
        for (int u : ugly) {

            while (n % u == 0) {
                n = n / u;
                // System.out.println(n + " " + u);
            }
        }

        return n == 1;
    }

}
// @lc code=end
