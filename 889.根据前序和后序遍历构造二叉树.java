/*
 * @lc app=leetcode.cn id=889 lang=java
 *
 * [889] 根据前序和后序遍历构造二叉树
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(postorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1, map);

    }

    TreeNode dfs(int[] preorder, int preleft, int preright, int[] postorder, int postleft, int postright,
            Map<Integer, Integer> map) {
        if (preleft > preright) {
            return null;
        }

        int count = 0;
        if (preleft < preright) {
            count = map.get(preorder[preleft + 1]) - postleft + 1;
        }
        TreeNode root = new TreeNode(preorder[preleft]);

        root.left = dfs(preorder, preleft + 1, preleft + count, postorder, postleft, postleft + count - 1, map);
        root.right = dfs(preorder, preleft + count + 1, preright, postorder, postleft + count, postright - 1, map);

        return root;
    }
}
// @lc code=end
