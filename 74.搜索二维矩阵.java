/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int verLine = RowSearch(matrix, target);

        if(verLine < 0) return false;

        return colSearch(matrix[verLine], target);
    }

    public int RowSearch(int[][] num, int target) {
        int left = -1, right = num.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (num[mid][0] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public boolean colSearch(int[] row, int target) {
        int left = 0, right = row.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(row[mid] == target) {
                return true;
            } else if(row[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

}
// @lc code=end
