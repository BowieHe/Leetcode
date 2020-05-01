import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root);
    }
    public int helper(TreeNode root){
        int sum = 0;
        if(root == null)
            return 0;
        if(root.left != null && (root.left.left == null && root.left.right == null)){
            sum += root.left.val;
        }
        sum += helper(root.left) + helper(root.right);
        return sum;
    }

}
// @lc code=end

