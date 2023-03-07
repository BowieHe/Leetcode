/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    backtrace(grid, i, j);
                    res++;
                }

            }
        }
        return res;
    }

    void backtrace(char[][] grid, int x, int y) {
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';
        backtrace(grid, x + 1, y);
        backtrace(grid, x - 1, y);
        backtrace(grid, x, y + 1);
        backtrace(grid, x, y - 1);
    }
}
// @lc code=end

