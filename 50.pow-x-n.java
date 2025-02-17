/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        int times = n;
        return times > 0 ? multi(x, n) : 1.0 / multi(x, -n);
    }

    public double multi(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double y = multi(x, n / 2);

        return n % 2 != 0 ? y * y * x : y * y;

    }
}
// @lc code=end
