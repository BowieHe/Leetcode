import java.util.List;

/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
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
    List<Integer> res = new ArrayList<Integer>();
    int currentCount = 0, maxCount = 0;
    TreeNode prevNode;

    public int[] findMode(TreeNode root) {
        traverse(root);
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
    
    void traverse(TreeNode root) {
        if(root == null) {
            return;
        }

        traverse(root.left);
        if(prevNode != null) {
            if(prevNode.val != root.val) {
                currentCount = 1;
                prevNode = root;
            } else if(prevNode.val == root.val) {
                currentCount++;
                
            }
            if(currentCount > maxCount) {
                while(!res.isEmpty()) {
                    res.remove(0);
                }
                res.add(prevNode.val);
            } else if(currentCount == maxCount) {
                res.add(prevNode.val);
            }
            maxCount = Math.max(maxCount, currentCount);
        } else {
            prevNode = root;
            currentCount = 1;
            maxCount = 1;
            res.add(root.val);
        }
        System.out.println("maxCount " + maxCount + " currentCount " + currentCount + " and val " + root.val);
        traverse(root.right);
    }
}
// @lc code=end

