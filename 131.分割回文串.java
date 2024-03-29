/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start

import java.util.List;

class Solution {

    int[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new int[n][n];

        dfs(s, 0);
        return ret;
    }


    public void dfs(String s, int i) {
        if(i == n) {
            ret.add(new ArrayList<String>(ans));
            return ;
        }

        for(int j = i; j < n;++j) {
            if(isPalindrom(s, i, j) == 1) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
    
    public int isPalindrom(String s, int i, int j) {
        if(f[i][j] != 0) {
            return f[i][j];
        }

        if(i >= j) {
            f[i][j] = 1;
        } else if(s.charAt(i) == s.charAt(j)) {
            f[i][j] = isPalindrom(s, i + 1, j - 1);
        } else {
            f[i][j] = -1;
        }

        return f[i][j];
    }
}
// @lc code=end

