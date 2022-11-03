import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=986 lang=java
 *
 * [986] 区间列表的交集
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new LinkedList<>();
        int i = 0, j = 0;
        while(i < firstList.length && j < secondList.length) {
            int a1 = firstList[i][0], a2 = firstList[i][1];
            int b1 = secondList[j][0], b2 = secondList[j][1];
            if(b2 >= a1 && a2 >= b1) {
                res.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }
            if(b2 < a2) {
                j++;
            } else {
                i++;
            }
        }
        return res.toArray(new int[0][0]);
    }
}
// @lc code=end

