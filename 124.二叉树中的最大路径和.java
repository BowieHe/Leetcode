/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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

    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPath(root);
        return max;
    }

    int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxPath(root.left) + root.val;
        int right = maxPath(root.right) + root.val;
        int combine = left + right - root.val;

        max = Math.max(max, Math.max(left, Math.max(combine, Math.max(right, root.val))));

        System.out
                .println("root:" + root.val + " and left sum:" + left + " and right sum:" + right + " and max: " + max);
        return Math.max(left, Math.max(right, root.val));
    }
}
// @lc code=end
