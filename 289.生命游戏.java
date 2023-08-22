/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length, col = board[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                // for loop iter each element
                board[i][j] = status(board, i, j, row, col);
            }
        }

        for(int i = 0; i < row; i++) {
            System.out.println(" ");
            for(int j = 0; j < col; j++) {
                System.out.print(board[i][j]);
                if(board[i][j] == -1) {
                    board[i][j] = 1;
                } else if(board[i][j] == 2) {
                    board[i][j] = 0;
                }
            }
        }

    }

    int status(int[][] board, int m, int n, int row, int col) {
        int aliveNum = 0;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if(j == 0 && i == 0) {
                    continue;
                }
                if(m + i >= 0 && n + j >= 0 && m + i < row && n + j < col) {
                    if(board[m + i][n + j] > 0) {
                        if(m == 1 && n == 0) {
                            System.out.println(i + " " + j);
                        }
                        aliveNum++;
                    }
                }
            }
        }
        // System.out.println(aliveNum + " with i j" + m + " " + n);
        // 0, 1 unchanged, -1: dead turn alice, 2: alive turn dead
        int currentStatus = board[m][n];
        if(currentStatus == 1) {
            if(aliveNum < 2 || aliveNum > 3) {
                return 2;
            } else {
                return 1;
            }
        } else {
            if(aliveNum == 3) {
                return -1;
            } return 0;
        }
    }
}
// @lc code=end

