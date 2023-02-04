import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            TreeNode node = new TreeNode(nums[i]);
            while(!dq.isEmpty()) {
                TreeNode topNode = dq.peekLast();
                if(node.val > topNode.val) {
                    dq.removeLast();
                    node.left = topNode;
                } else {
                    dq.addLast(node);
                    topNode.right = node;
                    break;
                }
            }
            if(dq.isEmpty()) dq.addLast(node);

        }

        return dq.getFirst();
    }
}
// @lc code=end

