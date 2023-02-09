/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } 
        if(root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        if(root.val == key) {
            if(root.left == null && root.right == null) {
                return null;
            }
            if(root.right == null) {
                return root.left;
            }
            if(root.left == null) {
                return root.right;
            }

            TreeNode successor = root.right;
            while(successor.left != null) {
                successor = successor.left;
            }
            root.right = deleteNode(root.right, successor.val);

            successor.left =root.left;
            successor.right = root.right;
            return successor;
        }

        return root;
    }
}
// @lc code=end

