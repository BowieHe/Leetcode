/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    int m, n;
    int maxVal;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        maxVal = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    maxVal = Math.max(maxVal, backtrace(grid, i, j));
                }
            }
        }
        return maxVal;
    }

    int backtrace(int[][] grid, int x, int y) {
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
            return 0;
        }

        grid[x][y] = 0;
        return 1 + 
        backtrace(grid, x + 1, y) + 
        backtrace(grid, x - 1, y) + 
        backtrace(grid, x, y + 1) + 
        backtrace(grid, x, y - 1);
    }
}
// @lc code=end

