import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
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
    public TreeNode invertTree(TreeNode root) {
        if(root == null)return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.right != null || cur.left != null){
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                if(cur.right != null)
                    queue.offer(cur.right);
                if(cur.left != null)
                    queue.offer(cur.left);
            }
            
        }
        return root;
    }
}
// @lc code=end

