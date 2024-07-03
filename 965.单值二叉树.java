/*
 * @lc app=leetcode.cn id=965 lang=java
 *
 * [965] 单值二叉树
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

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

    Integer s;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if ((root.left != null && root.val != root.left.val) || (root.right != null && root.val != root.right.val)) {
            return false;
        }

        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
// @lc code=end
