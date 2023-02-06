import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import com.sun.org.apache.bcel.internal.classfile.Node;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层序遍历 II
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
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int sz = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for(int i = 0; i < sz; i++) {
                TreeNode curNode = queue.poll();
                if(curNode != null) {
                    curLevel.add(curNode.val);
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                }
            }
            if(curLevel.size() > 0) {
                res.addFirst(curLevel);
            }
        }
        return res;
    }
}
// @lc code=end

