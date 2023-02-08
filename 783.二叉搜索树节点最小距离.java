/*
 * @lc app=leetcode.cn id=783 lang=java
 *
 * [783] 二叉搜索树节点最小距离
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int minVal;
    TreeNode prevVal;
    public int minDiffInBST(TreeNode root) {
        minVal = Integer.MAX_VALUE;
        traverse(root);
        return minVal;
    }

    void traverse(TreeNode root) {
        if(root == null) {
            return;
        }

        traverse(root.left);

        if(prevVal != null) {
            minVal = Math.min(minVal, root.val - prevVal.val);
        }
        prevVal = root;

        traverse(root.right);
    }
}
// @lc code=end

