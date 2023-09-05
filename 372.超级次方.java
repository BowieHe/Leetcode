/*
 * @lc app=leetcode.cn id=372 lang=java
 *
 * [372] 超级次方
 */

// @lc code=start
class Solution {

    int MOD = 1337;
    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }

    public int dfs(int a, int[] b, int len) {
        if(len == -1) return 1;

        return pow(dfs(a, b, len - 1), 10) * pow(a, b[len]) % MOD;
    }

    int pow(int a, int b) {
        int ans = 1;
        a %= MOD;
        while(b-- > 0) ans = ans * a % MOD;
        return ans; 
    }
}
// @lc code=end

