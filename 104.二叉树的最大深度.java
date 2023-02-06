/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int maxVal = 0;
        // if(root.left != null) {
            maxVal = Math.max(maxVal, maxDepth(root.left));
        // } else if(root.right != null) {
            maxVal = Math.max(maxVal, maxDepth(root.right));
        // }
        return maxVal + 1;
    }
}
// @lc code=end

