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

    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (prestart > preend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int leftIndex = map.get(root.val);
        int leftSize = leftIndex - instart;

        root.left = build(preorder, prestart + 1, prestart + leftSize, inorder, instart, leftIndex - 1);
        root.right = build(preorder, prestart + leftSize + 1, preend, inorder, leftIndex + 1, inend);

        return root;
    }

}
// @lc code=end
