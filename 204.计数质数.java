import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        if(n <= 2)return 0;
        int count = 0;
        boolean[] nums = new boolean[n];
        for(int i = 2; i < n; i++){
            if(!nums[i]){
                for(int j = 2; j*i < n; j++){
                    nums[j * i] = true;
                }
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

