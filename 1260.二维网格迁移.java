/*
 * @lc app=leetcode.cn id=1260 lang=java
 *
 * [1260] 二维网格迁移
 */

// @lc code=start
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int rowNum = (k / n) % m;
        int colNum = k % n;

        int[][] rowMove = new int[m][n];
        for(int i = 0; i < rowNum; i++) {
            moveRow(grid);
        }

        

    }

    void moveRow(int[][] grid) {
        int[] temp = new int[grid[0].length];
        for (int i = 1; i < grid.length; i++) {
            temp = grid[i];
            if (i < grid.length - 1) {
                int[] prev = grid[i - 1];
                grid[i] = prev;
            } else {
                grid[0] = temp;
            }
        }

    }
}
// @lc code=end
