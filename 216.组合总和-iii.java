/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    int k;
    List path = new ArrayList<Integer>();
    List res = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        dfs(n, 9);
        return res;

    }

    void dfs(int rest, int index) {
        if (path.size() > this.k || rest < 0) {
            return;
        }

        int resNum = k - path.size();
        if(((1 + resNum) * resNum / 2) > rest) {
            return;
        }

        if (rest == 0 && path.size() == this.k) {
            res.add(new ArrayList(path));
            return;
        }

        for(int j = index; j >= resNum; j--) {
            path.add(j);
            dfs(rest - j, j - 1);
            path.remove(path.size() - 1);
        }

        return;
    }
}
// @lc code=end
