import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> path = new LinkedList<>();
        construct(root, "", path);
        return path;
    }
    public void construct(TreeNode root, String path, LinkedList<String> paths){
        if(root != null){   
            path += Integer.toString(root.val);
            if(root.left ==null && root.right == null)
                paths.add(path);
            else{
                path += "->";
                construct(root.left, path, paths);
                construct(root.right, path, paths);
            }
        }
    }
}
// @lc code=end

