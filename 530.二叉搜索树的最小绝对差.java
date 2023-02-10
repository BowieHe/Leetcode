/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
    TreeNode prevNode;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return min;
    }

    void traverse(TreeNode root) {
        if(root == null) {
            return;
        }

        traverse(root.right);
        if(prevNode != null) {
            min = Math.min((prevNode.val - root.val), min);
        }
        System.out.println(min);
        prevNode = root;
        traverse(root.left);

    }
}
// @lc code=end

