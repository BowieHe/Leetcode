/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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

    int val;
    int depth = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return val;
    }

    void traverse(TreeNode root, int k) {
        if(root == null) {
            return;
        }

        traverse(root.left, k);
        depth++;
        if(depth == k) {
            val = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
// @lc code=end

