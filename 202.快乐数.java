import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getSum(n);
        while(fast != 1 && fast != slow){
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        }
        return fast == 1;
    }
    public int getSum(int n){
        int sum = 0;
        while(n > 0){
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }
}
// @lc code=end

