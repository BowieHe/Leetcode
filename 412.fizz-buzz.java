import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=412 lang=java
 *
 * [412] Fizz Buzz
 */

// @lc code=start
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String temp = "";
            if(i % 3 == 0)temp += "Fizz";
            if(i % 5 == 0)temp += "Buzz";
            else if(i % 3 != 0)temp += i + "";
            ans.add(temp);
        }
        return ans;
    }
}
// @lc code=end

