/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return pathSum(root.left, sum) +
            pathSum(root.right, sum) +
            path(root, sum, 0);
    }
    public int path(TreeNode root, int sum, int cur){
        if(root == null)
            return 0;
        int res = 0;
        cur += root.val;
        if(cur == sum)
            res++;
        res += path(root.left, sum, cur);
        res += path(root.right, sum, cur);
        return res;
    }
}
// @lc code=end

