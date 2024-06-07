/*
 * @lc app=leetcode.cn id=793 lang=java
 *
 * [793] 阶乘函数后 K 个零
 */

// @lc code=start
class Solution {
    public int preimageSizeFZF(int k) {
        return leftBound(k + 1) - leftBound(k);
    }

    int leftBound(int k) {
        long left = 0, right = Long.MAX_VALUE;

        while (left < right) {
            long mid = left + (right - left) / 2;
            long zero = zeroNum(mid);
            if (zero < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
            // System.out.println(mid);
        }

        return (int) left;
    }

    long zeroNum(long n) {
        long t = 0;
        long temp = n;
        while (temp > 0) {
            t += temp / 5;
            temp /= 5;
        }
        return t;
    }
}
