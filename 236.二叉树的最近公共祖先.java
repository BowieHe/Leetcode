/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
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
    boolean containsP, containsQ;
    TreeNode commonNode = null;


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root == p || root == q) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.left, p, q);
        
        if(leftNode != null && rightNode != null) {
            return root;
        } else if(leftNode == null && rightNode == null) {
            return null;
        } else {
            return leftNode == null? rightNode: leftNode;
        }
    }

}
// @lc code=end

