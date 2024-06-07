/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long left = 1, right = 1;
        for (int p : piles) {
            right = Math.max(p, right);
        }

        System.out.println(right);

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (f(mid, piles) > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
            // System.out.println("left:" + left + " right: " + right);
        }

        return (int) left;

    }

    int f(long spd, int[] piles) {
        int h = 0;
        for (int p : piles) {
            h += (p / spd);
            if (p % spd > 0) {
                h += 1;
            }
        }
        return h;
    }
}
// @lc code=end
