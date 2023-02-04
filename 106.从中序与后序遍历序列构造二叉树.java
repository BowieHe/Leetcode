import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    Map<Integer, Integer> valIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++) {
            valIndex.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd,
            int[] postorder, int postStart, int postEnd) {
        if(inStart > inEnd) {
            return null;
        }

        int val = postorder[postEnd];
        // System.out.println("get val " + val + " and index " + postEnd);
        int index = valIndex.get(val);
        int gap = index - inStart;
        TreeNode root = new TreeNode(val);
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + gap - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + gap, postEnd - 1);

        return root;
    }
}
// @lc code=end

