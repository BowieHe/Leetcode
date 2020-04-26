/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    public boolean isBalanced(TreeNode root) {
        return diff(root) != -1; 
    }
    public int diff(TreeNode root){
        if(root == null)return 0;
        int m1 = diff(root.left);
        if(m1 == -1)
            return -1;
        int m2 = diff(root.right);
        if(m2 == -1)
            return -1;
        return Math.abs(m1 - m2) < 2? Math.max(m1, m2) + 1: -1;
    }
}
// @lc code=end

