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

    int getZeroNumber(int n) {
        int res = 0;
        for(int d = n; d/ 5 > 0; d/= 5) {
            res += d / 5;
        }
        return res;
    } 

    int leftBound(int k) {
        int left = 0, right = 5 * k;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(getZeroNumber(mid) < k) {
                left = mid + 1;
            } else if(getZeroNumber(mid) > k) {
                right = mid - 1;
            } else if(getZeroNumber(mid) == k) {
                right = mid - 1;
            }
        }
        System.out.println(left);
        return left;
    }

     int rightBound(int k) {
        int left = 0, right = 5 * k;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(getZeroNumber(mid) < k) {
                left = mid + 1;
            } else if(getZeroNumber(mid) > k) {
                right = mid - 1;
            } else if(getZeroNumber(mid) == k) {
                left = mid + 1;
            }
        }

        System.out.println(left);
        return left;
    }
}
// @lc code=end

