/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int weight = matrix[0].length, height = matrix.length;
        int left = 0, right = weight * height - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(get(mid, matrix) > target) {
                right = mid - 1;
            } else if(get(mid, matrix) < target) {
                left = mid + 1;
            } else if(get(mid, matrix) == target) {
                return true;
            }
        }
        return false;
    }

    public int get(int num, int[][] matrix) {
        int turn = matrix[0].length;
        int weight = num / turn;
        int height = num % turn;
        return matrix[weight][height];
    }
}
// @lc code=end

