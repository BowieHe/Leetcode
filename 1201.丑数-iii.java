/*
 * @lc app=leetcode.cn id=1201 lang=java
 *
 * [1201] 丑数 III
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int left = 1, right = (int) 2e9;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f(mid, a, b, c) < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    long f(int num, int a, int b, int c) {
        long aSet = num / a, bSet = num / b, cSet = num / c;
        long ab = num / lcm(a, b);
        long ac = num / lcm(a, c);
        long bc = num / lcm(b, c);
        long abc = num / lcm(a, lcm(b, c));
        return aSet + bSet + cSet - ab - ac - bc + abc;
    }

    long gcd(long a, long b) {
        if (b == 0)
            return a;
        if (a < b) {
            return gcd(b, a);
        }
        return gcd(b, a % b);
    }

    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

}
// @lc code=end
