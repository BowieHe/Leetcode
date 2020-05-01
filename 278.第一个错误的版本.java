/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] 第一个错误的版本
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n <= 1)return n;
        int left = 0, right = n;
        while(left < right){
            int mid = ((right - left)/ 2) + left;
            if(isBadVersion(mid)){
                right = mid;
                continue;
            }else{
                left = ++mid;
                continue;
            }
        }
        return left;
    }
}
// @lc code=end

