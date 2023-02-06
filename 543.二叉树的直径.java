/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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

    int maxVal = 0; 

    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return maxVal;
    }

    int traverse(TreeNode root) {
        if(root == null) {
            return 0;
        } 

        int maxLeft = traverse(root.left);
        int maxRight = traverse(root.right);

        maxVal = Math.max(maxVal, maxLeft + maxRight);
        return Math.max(maxLeft, maxRight) + 1;
    }
}
// @lc code=end

