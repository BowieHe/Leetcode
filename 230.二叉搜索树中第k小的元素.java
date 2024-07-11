/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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

    // int count;
    // int val;

    // public int kthSmallest(TreeNode root, int k) {
    // count = k;
    // val = -1;

    // traverse(root);
    // return val;
    // }

    // void traverse(TreeNode root) {
    // if (root == null) {
    // return;
    // }

    // traverse(root.left);
    // count--;
    // if (count == 0) {
    // val = root.val;
    // }
    // traverse(root.right);

    // return;
    // }

    // solution 2
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        int res = -1;
        int left = kthSmallest(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
        }
        int right = kthSmallest(root.right, k);

        res = Math.max(res, Math.max(left, right));

        return res;
    }
}
// @lc code=end
