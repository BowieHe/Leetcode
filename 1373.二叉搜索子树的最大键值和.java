/*
 * @lc app=leetcode.cn id=1373 lang=java
 *
 * [1373] 二叉搜索子树的最大键值和
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

    public int maxSumBST(TreeNode root) {

        this.max = 0;
        traverse(root);
        return max;
    }

    // [is BST(1, 0), minVal, maxVal, sum]
    int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[] { 1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
        }

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        int[] res = new int[4];
        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
            // bst make
            res = new int[] { 1, Math.min(root.val, left[1]), Math.max(root.val, right[2]),
                    left[3] + right[3] + root.val };

            max = Math.max(max, res[3]);
        } else {
            res[0] = 0;
        }

        // else if (left[0] == 1) {
        // res = left;
        // res[0] = 0;
        // } else if (right[0] == 1) {
        // res = right;
        // res[0] = 0;
        // } else {
        // res = new int[] { 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
        // }

        return res;
    }
}
// @lc code=end
