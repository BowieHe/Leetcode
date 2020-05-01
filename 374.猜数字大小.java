/*
 * @lc app=leetcode.cn id=374 lang=java
 *
 * [374] 猜数字大小
 */

// @lc code=start
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while(left <= right){
            int mid = left + (right - left)/2;
            int ans = guess(mid);
            switch(ans){
            case 1:
                left = mid + 1;
                continue;
            case -1:
                right = mid - 1;
                continue;
            case 0:
                return mid;
            }
        }
        return 0;
    }
}
// @lc code=end

