import java.lang.Character.Subset;
import java.util.ArrayList;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
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
    Map<String, Integer> subTreeRecord;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        subTreeRecord = new HashMap<>();
        res = new ArrayList<>();
        traverse(root);

        return res;
    }

    String traverse(TreeNode root) {
        if(root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;
        System.out.println(subTree);

        int freq = subTreeRecord.getOrDefault(subTree, 0);
        if(freq == 1) {
            res.add(root);
        }
        subTreeRecord.put(subTree, freq + 1);
        return subTree;
    }
}
// @lc code=end

