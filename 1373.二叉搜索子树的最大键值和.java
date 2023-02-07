/*
 * @lc app=leetcode.cn id=1373 lang=java
 *
 * [1373] 二叉搜索子树的最大键值和
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
    int maxVal = 0;
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxVal;
    }

    int[] traverse(TreeNode root) {
        
        if(root == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        } 

        int[] maxLeft = traverse(root.left);
        int[] maxRight = traverse(root.right);

        int[] res = new int[4];

        if(maxLeft[0] == 1 && maxRight[0] == 1 && root.val > maxLeft[2] && root.val < maxRight[1]) {
            res[0] = 1;
            res[1] = Math.min(maxLeft[1], root.val);
            res[2] = Math.max(maxRight[2], root.val);
            res[3] = root.val + maxLeft[3] + maxRight[3];
            maxVal = Math.max(maxVal, res[3]);
        } else {
            res[0] = 0;
        }
        return res;
    }
}
// @lc code=end

