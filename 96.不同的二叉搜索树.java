import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        if(n == 0) return 0;
        return build(1, n);
        // return res.size();
    }

    Integer build(int lo, int hi) {
        int res = 0;

        if(lo > hi) {
            return 1;
        }
        if(memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        for(int i = lo; i <= hi; i++) {

            int leftTree = build(lo, i - 1);

            int rightTree = build(i + 1, hi);
            System.out.println(String.format("val:%d, left:%d, right: %d", i , leftTree, rightTree));
            res += (leftTree * rightTree);
        }
        memo[lo][hi] = res;
        return res;
    }
}
// @lc code=end

