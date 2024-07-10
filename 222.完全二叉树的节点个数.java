/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

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
    public int countNodes(TreeNode root) {
        // if (root == null) {
        // return 0;
        // }

        // Deque<TreeNode> dq = new ArrayDeque<>();
        // dq.add(root);
        // int count = 0;
        // while (!dq.isEmpty()) {
        // TreeNode t = dq.poll();
        // count++;
        // if (t.left != null) {
        // dq.add(t.left);
        // }
        // if (t.right != null) {
        // dq.add(t.right);
        // }
        // }

        // return count;

        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }
}
// @lc code=end
