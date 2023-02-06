import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int sz = queue.size();
            LinkedList<Integer> cur = new LinkedList<>();
            for(int i = 0; i < sz; i++) {
                TreeNode curNode = queue.poll();
                if(curNode == null) {
                    continue;
                }
                if(level % 2 == 1) {
                    cur.addFirst(curNode.val);
                } else {
                    cur.addLast(curNode.val);
                }
                queue.offer(curNode.left);
                queue.offer(curNode.right);
            }
            level++;
            if(cur.size() > 0) {
                res.add(cur);
            }
        }

        return res;
    }
}
// @lc code=end

