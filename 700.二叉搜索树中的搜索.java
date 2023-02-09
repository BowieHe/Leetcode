/*
 * @lc app=leetcode.cn id=700 lang=java
 *
 * [700] 二叉搜索树中的搜索
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
    TreeNode res;   
    public TreeNode searchBST(TreeNode root, int val) {
        
        return traverse(root, val);
    }
    TreeNode traverse(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        if(root.val < val) {
            return traverse(root.right, val);
        } else if(root.val > val) {
            return traverse(root.left, val);
        }
        if(root.val == val) {
            return root;
        }
        return null;
    }
}
// @lc code=end

