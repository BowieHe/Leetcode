import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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
    /*class MyTreeNode{
        TreeNode root;
        int start;
        int end;
        public MyTreeNode(TreeNode root, int start, int end){
            this.end = end;
            this.start = start;
            this.root = root;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        Queue<MyTreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(0);
        queue.offer(new MyTreeNode(root, 0, nums.length));
        while(!queue.isEmpty()){
            MyTreeNode myRoot = queue.poll();
            int start = myRoot.start;
            int end = myRoot.end;
            TreeNode curRoot = myRoot.root;
            int mid = (start + end) >>> 1;
            curRoot.val = nums[mid];
            if(start < mid){
                curRoot.left = new TreeNode(0);
                queue.offer(new MyTreeNode(curRoot.left, start, mid));
            }
            if(mid + 1 < end){
                curRoot.right = new TreeNode(0);
                queue.offer(new MyTreeNode(curRoot.right, mid + 1, end));
            }

        }
        return root;
    }*/
    class MyTree{
        TreeNode root;
        int start;
        int end;
        public MyTree(TreeNode root, int start, int end){
            this.root = root;
            this.end = end;
            this.start = start;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums){
        if(nums.length == 0)return null;
        Queue<MyTree> queue = new LinkedList<>();
        TreeNode root = new TreeNode(0);
        queue.offer(new MyTree(root, 0, nums.length));
        while(!queue.isEmpty()){
            MyTree myNode = queue.poll();
            int start = myNode.start;
            int end = myNode.end;
            TreeNode curRoot = myNode.root;
            int mid = (start + end) >>> 1;
            curRoot.val = nums[mid];
            if(start < mid){
                curRoot.left = new TreeNode(0);
                queue.offer(new MyTree(curRoot.left, start, mid));
            }
            if(mid + 1 < end){
                curRoot.right = new TreeNode(0);
                queue.offer(new MyTree(curRoot.right, mid + 1, end));
            }
        }
        return root;
    }
}
// @lc code=end

