import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return ans;
        queue.add(root);
        while(!queue.isEmpty()){
            ans.add(new ArrayList<Integer>());
            int len = queue.size();
            for(int i = 0; i < len; i++){//if use i<queue.size(), the loop time is unsure
                root = queue.remove();
                ans.get(level).add(root.val);
                if(root.left != null)queue.add(root.left);
                if(root.right != null)queue.add(root.right);
            }
            level++;
        }
        Collections.reverse(ans);//reverse the list
        return ans;
    }
}
// @lc code=end

