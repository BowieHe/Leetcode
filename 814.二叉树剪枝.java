/*
 * @lc app=leetcode.cn id=814 lang=java
 *
 * [814] 二叉树剪枝
 */

// @lc code=start

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        dfs(root);

        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

    boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean lPrune = false, rPrune = false;
        if (dfs(root.left)) {
            root.left = null;
            lPrune = true;
        }
        if (dfs(root.right)) {
            root.right = null;
            rPrune = true;
        }

        if (lPrune && rPrune && root.val == 0) {
            return true;
        } else {
            return false;
        }

    }
}
// @lc code=end
