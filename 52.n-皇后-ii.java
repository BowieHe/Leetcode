/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N 皇后 II
 */

// @lc code=start
class Solution {
    int res = 0;
    public int totalNQueens(int n) {
        int[][] map = new int[n][n];
        dfs(0, map);
        return res;
    }

    public void dfs(int row, int[][] map) {
        // if(row == n - 1 && isValid(row, index, n)) {
        //     res++;
        //     return;
        // }

        int n = map.length;
        for(int i = 0; i < n; i++) {
            if(isValid(row, i, map)) {
                if(row == n - 1) {
                    // System.out.println("=====");
                    // for(int[] m: map) {
                    //     System.out.println(Arrays.toString(m));
                    // }
                    res++;
                    return;
                }
                map[row][i] = 1;
                dfs(row + 1, map);
                map[row][i] = 0;
            }
        }
    }

    public boolean isValid(int row, int index, int[][] map) {

        int n = map.length;
        for(int i = 1; i <= row; i++) {
            if(index - i >= 0 && map[row - i][index - i] == 1) {
                return false;
            } else if(index + i < n && map[row - i][index + i] == 1) {
                return false;
            } else if(map[row - i][index] == 1) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

