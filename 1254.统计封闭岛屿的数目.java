/*
 * @lc app=leetcode.cn id=1254 lang=java
 *
 * [1254] 统计封闭岛屿的数目
 */

// @lc code=start
class Solution {
    int m, n;
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for(int i = 0; i < m; i++) {
            backtrace(grid, i, 0, 1);
            backtrace(grid, i, n - 1, 1);
        }
        for(int i = 0; i < n; i++) {
            backtrace(grid, 0, i, 1);
            backtrace(grid, m - 1, i, 1);
        }

        int num = 2;
        for(int i = 1; i < m -1; i++) {
            for(int j = 1; j < n - 1; j++) {
                if(grid[i][j] == 0) {

                    System.out.println(i + " " + j + " " + grid[i][j]);
                    backtrace(grid, i, j, num);
                    num++;
                }
            }
        }
        return num - 2;
    }

    void backtrace(int[][] grid, int x, int y, int num) {

        // System.out.println("get value " + grid[x][y] + " " + m + " " + n);
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 0) {
            return;
        }

        grid[x][y] = num;
        
        backtrace(grid, x + 1, y, num);
        backtrace(grid, x - 1, y, num);
        backtrace(grid, x, y - 1, num);
        backtrace(grid, x, y + 1, num);
    }
}
// @lc code=end

