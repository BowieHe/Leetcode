/*
 * @lc app=leetcode.cn id=965 lang=java
 *
 * [965] 单值二叉树
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
    public boolean isUnivalTree(TreeNode root) {

        Integer val = root.val;
        if(val == null) return true;
        return equals(root, val);
    }

    public boolean equals(TreeNode root, int val) {
        if(root == null) {
            return true;
        } else if(root.val != val) {
            return false;
        }

        if(!equals(root.left, val) || !equals(root.right, val)) {
            return false;
        }
        return true;
    }
}
// @lc code=end

