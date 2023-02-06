/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
    public void flatten(TreeNode root) {
        // end condition
        if(root == null) {
            return;
        }

        // flatten left and right tree
        flatten(root.left);
        flatten(root.right);

        TreeNode cur = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        cur.left = null;
        cur.right = left;
        while(cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;
    }
}
// @lc code=end

