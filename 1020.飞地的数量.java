/*
 * @lc app=leetcode.cn id=1020 lang=java
 *
 * [1020] 飞地的数量
 */

// @lc code=start
class Solution {
    int m, n;
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // System.out.println(m + " " + n);
        for(int i = 0; i < m; i++) {
            backtrace(grid, i, 0);
            backtrace(grid, i, n - 1);
        }
        for(int i = 0; i < n; i++) {
            backtrace(grid, 0, i);
            backtrace(grid, m - 1, i);
        }

        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    void backtrace(int[][] grid, int x, int y) {
        // System.out.println(x + " " + y + " " + grid[1][0]);
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
            return ;
        }
        // System.out.println(x + " test " + y); 
            grid[x][y] = 0;
            backtrace(grid, x + 1, y);
            backtrace(grid, x - 1, y);
            backtrace(grid, x, y + 1);
            backtrace(grid, x, y - 1);

    }
}
// @lc code=end

