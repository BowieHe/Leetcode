import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            valIndex.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(preorder[0]);
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd) {
            return null;
        }
        int index = valIndex.getOrDefault(preorder[preStart], 9999);
        
        int len = index - inStart;
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = build(preorder, preStart + 1, preStart + len, 
                inorder, inStart, index - 1);
        root.right = build(preorder, preStart + len + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}
// @lc code=end

