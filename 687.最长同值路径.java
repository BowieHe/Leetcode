/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
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

    int maxDep;

    public int longestUnivaluePath(TreeNode root) {
        maxDep = 0;
        traverse(root);
        return maxDep;
    }

    int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);

        int lRes = 0, rRes = 0;
        if (root.left != null && root.left.val == root.val) {
            lRes = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rRes = right + 1;

        }

        System.out.println("left:" + lRes + " and right:" + rRes + " and root:" + root.val);
        maxDep = Math.max(maxDep, lRes + rRes);

        return Math.max(lRes, rRes);
    }
}
// @lc code=end
