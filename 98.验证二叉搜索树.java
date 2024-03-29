/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    public boolean isValidBST(TreeNode root) {
        return traverse(root, null, null);
    }

    boolean traverse(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null) {
            return true;
        }

        if(min != null && root.val <= min.val) return false;
        if(max != null && root.val >= max.val) return false;
        return traverse(root.left, min, root) && traverse(root.right, root, max);
    }
    
}
// @lc code=end

